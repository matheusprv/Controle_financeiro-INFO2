/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */







/*O usuário pode escolher objetivos futuros, como algo que queira comprar
    Ele irá por os preço do produto, quanto ele tem guardado, quanto rá guardar e o tempo que ficará juntando, que pode ser calculado automaticamente
    Caso queira, o programa pode adicionar o valor mensal que ele definiu ao seu caixa para que ele não precise ficar o tempo todo lembrando
*/


package Telas;

import ConexaoBD.DAOMovimentacoes;
import ConexaoBD.DAOObjetivos;
import ConexaoBD.DAOUsuario;
import Objetos.Movimentacoes;
import Objetos.Objetivos;
import Objetos.Usuario;
import java.awt.Color;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matheus
 */
public class Tela_Objetivos extends javax.swing.JFrame {
    Usuario u;
    ArrayList<Objetivos> objetivos =new ArrayList<Objetivos>();
    DefaultTableModel tabela;
    boolean atualizarDeletar = false; //Responsavel por saber se haverá alguma modificação na tabela a fim de aproveitar o mesmo botão de adicionar para também atualizar
    int linhaSelected=0;
    ArrayList<Objetivos> obterDoBanco;
    boolean guardar_no_dia =true;// Permite, ou não, que o usuário digite o dia que o dinhiro será guardado
    
    DAOObjetivos objetivosBD = new DAOObjetivos();
    DAOUsuario daousuario = new DAOUsuario();
    
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate data = null;
    
    public Tela_Objetivos(Usuario usuario) {
        initComponents();
        u= usuario;
        
        tabela = (DefaultTableModel) jTable.getModel();
        tabela.setColumnCount(7);
        
        
        //Esse botão só aparece quando o usuário for atualizarDeletar ou deletar algo após clicar no item na jTable
        bDeletar.setVisible(atualizarDeletar);
        
         
        
    }

    private Tela_Objetivos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pCarregar = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldMeta = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        bVoltar = new javax.swing.JButton();
        tData = new javax.swing.JFormattedTextField();
        jFormattedTextFieldPreco = new javax.swing.JFormattedTextField();
        bDeletar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        bAdicionarAtualizar = new javax.swing.JButton();
        jFormattedTextFieldCaixa = new javax.swing.JFormattedTextField();
        jFormattedTextFieldAporte_Mensal = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        bCalcularData = new javax.swing.JButton();
        bCalcularDinheiroMensal = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bSim = new javax.swing.JButton();
        bNao = new javax.swing.JButton();
        tData1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Objetivos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pCarregar.setBackground(new java.awt.Color(204, 204, 204));
        pCarregar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Carregando... Por favor aguarde.");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Isso pode demorar um pouco...");

        javax.swing.GroupLayout pCarregarLayout = new javax.swing.GroupLayout(pCarregar);
        pCarregar.setLayout(pCarregarLayout);
        pCarregarLayout.setHorizontalGroup(
            pCarregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCarregarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pCarregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pCarregarLayout.setVerticalGroup(
            pCarregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCarregarLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pCarregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 220, 60));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Meta:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Preço:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Data esperada: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Guardado:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, -1, -1));

        jTextFieldMeta.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextFieldMeta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldMetaKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldMeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 200, 38));

        jTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Meta", "Valor", "Guardado", "Dinhe. Mensal", "Data estimada", "Auto adicionar", "Dia de adicionar"
            }
        ));
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 346, 739, 260));

        bVoltar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bVoltar.setText("Voltar");
        bVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(bVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        try {
            tData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(tData, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 200, 38));

        jFormattedTextFieldPreco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.00"))));
        jFormattedTextFieldPreco.setText("0,00");
        getContentPane().add(jFormattedTextFieldPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 199, 38));

        bDeletar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bDeletar.setText("Deletar");
        bDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeletarActionPerformed(evt);
            }
        });
        getContentPane().add(bDeletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 195, 150, -1));

        bCancelar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(bCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, 150, -1));

        bAdicionarAtualizar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bAdicionarAtualizar.setText("Adicionar");
        bAdicionarAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAdicionarAtualizarActionPerformed(evt);
            }
        });
        getContentPane().add(bAdicionarAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 150, -1));

        jFormattedTextFieldCaixa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.00"))));
        jFormattedTextFieldCaixa.setText("0,00");
        getContentPane().add(jFormattedTextFieldCaixa, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 199, 38));

        jFormattedTextFieldAporte_Mensal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.00"))));
        jFormattedTextFieldAporte_Mensal.setText("0,00");
        getContentPane().add(jFormattedTextFieldAporte_Mensal, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 199, 38));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Guardar mensalmente:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, -1, -1));

        bCalcularData.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bCalcularData.setText("Calcular data");
        bCalcularData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCalcularDataActionPerformed(evt);
            }
        });
        getContentPane().add(bCalcularData, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 150, -1));

        bCalcularDinheiroMensal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bCalcularDinheiroMensal.setText("Calc. Din. mensal");
        bCalcularDinheiroMensal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCalcularDinheiroMensalActionPerformed(evt);
            }
        });
        getContentPane().add(bCalcularDinheiroMensal, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Adicionar automaticamente no caixa?");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 260, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Guardar no dia: ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, -1, -1));

        bSim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bSim.setText("Sim");
        bSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSimActionPerformed(evt);
            }
        });
        getContentPane().add(bSim, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, -1, -1));

        bNao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bNao.setText("Não");
        bNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNaoActionPerformed(evt);
            }
        });
        getContentPane().add(bNao, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, -1, -1));

        tData1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tData1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tData1FocusGained(evt);
            }
        });
        tData1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tData1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tData1KeyTyped(evt);
            }
        });
        getContentPane().add(tData1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, 100, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVoltarActionPerformed
        Tela_opcoes abrir = new Tela_opcoes(u);
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bVoltarActionPerformed
        
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        bSim.setBackground(Color.green);
        bNao.setBackground(Color.gray);
        tData1.setEditable(false);
        objetivos = objetivosBD.pegarObjetivos(u);
        if(objetivos!=null){    
            
            for(Objetivos obj: objetivos){
                String auto_adicionar = "Não";
                String data_auto_adicionar = "Não definida";
                if(obj.isAdicionar_no_caixa()){// Verifica se o usuário deixou marcado uma data pré-definida para adicionar um valor no seu caixa
                    auto_adicionar= "Sim";
                    data_auto_adicionar = ""+ obj.getData_adicionar_no_caixa().getDayOfMonth();
                    LocalDate hoje =LocalDate.now();
                    if(hoje.until(obj.getData_adicionar_no_caixa(), ChronoUnit.DAYS)<=0){ //É verificado se já passou do dia do pagamento 
                        long mesesPassados= hoje.until(obj.getData_adicionar_no_caixa(), ChronoUnit.MONTHS);
                        if(mesesPassados==0){
                            mesesPassados=-1;
                        }
                        else{
                            mesesPassados--;
                        }
                        //Adiciono na tabela de movimentações uma que é o dinheiro a mais
                        DAOMovimentacoes movimentacoes = new DAOMovimentacoes();
                        ArrayList<Movimentacoes> movimentos = movimentacoes.pegarTodasMovimentacoes(u);
                        int proxima_movimentacao;
                        try{
                            proxima_movimentacao = movimentos.get(0).getNumero_movimentacao();
                        }catch(Exception e){
                            proxima_movimentacao = 0;
                        }
                            
                        for(int i=1; i<=(mesesPassados*(-1)); i++){// Verifica quantas meses se passaram para adicionar o número correto de movimentações
                            Movimentacoes adicionarMovimentacao =null;
                            if(mesesPassados*(-1)>1){
                                adicionarMovimentacao = new Movimentacoes(u.getCpf(), obj.getMeta()+" obj", proxima_movimentacao+i, obj.getAporte_mensal(), obj.getData_adicionar_no_caixa().plusMonths(i-1), LocalTime.MIDNIGHT, false, obj.getIdObjetivo());                        
                            }
                            else{
                                adicionarMovimentacao = new Movimentacoes(u.getCpf(), obj.getMeta()+" obj", proxima_movimentacao+i, obj.getAporte_mensal()*mesesPassados*(-1), obj.getData_adicionar_no_caixa(), LocalTime.MIDNIGHT, false, obj.getIdObjetivo());                        
                            }
                            movimentacoes.inserirNoBD(adicionarMovimentacao);
                            
                        }
                        obj.setCaixa(((obj.getCaixa()+(obj.getAporte_mensal()*mesesPassados*(-1)))));
                        LocalDate setarDataDoProximoAporte = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), obj.getData_adicionar_no_caixa().getDayOfMonth());
                        obj.setData_adicionar_no_caixa(setarDataDoProximoAporte.plusMonths(1));
                        objetivosBD.atualizarNoBD(obj);
                        u.setSaldo(-(obj.getAporte_mensal()*mesesPassados*(-1)));
                        daousuario.atualizarSaldo(u);

                        
                    }
                    
                }
                
                tabela.addRow(new Object[]{obj.getMeta(),"R$ "+obj.getPreco(), "R$ "+obj.getCaixa(), "R$ "+obj.getAporte_mensal(),obj.getData_estimada().format(formato), auto_adicionar, data_auto_adicionar});
            }
        }
        pCarregar.setVisible(false);
            
    }//GEN-LAST:event_formWindowOpened

    
    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        linhaSelected = this.jTable.getSelectedRow();
        jTextFieldMeta.setEditable(false);
        
        String preco = ""+objetivos.get(linhaSelected).getPreco();
        String caixa = ""+objetivos.get(linhaSelected).getCaixa();
        String aporte_mensal = ""+objetivos.get(linhaSelected).getAporte_mensal();
        
        jTextFieldMeta.setText(objetivos.get(linhaSelected).getMeta());
        jFormattedTextFieldPreco.setText(preco);
        jFormattedTextFieldCaixa.setText(caixa);
        jFormattedTextFieldAporte_Mensal.setText(aporte_mensal);
        tData.setText(""+objetivos.get(linhaSelected).getData_estimada().format(formato));
        if(objetivos.get(linhaSelected).isAdicionar_no_caixa()){
            guardar_no_dia = true;
            bSim.setBackground(Color.green);
            bNao.setBackground(Color.gray);
            tData1.setText(objetivos.get(linhaSelected).getData_adicionar_no_caixa().getDayOfMonth()+"");
        }
        else{
            guardar_no_dia = false;
            tData1.setText("");
            bSim.setBackground(Color.gray);
            bNao.setBackground(Color.green);
        }

        atualizarDeletar=true;
        bAdicionarAtualizar.setText("Atualizar");
        bDeletar.setVisible(atualizarDeletar);
    }//GEN-LAST:event_jTableMouseClicked

    private void bAdicionarAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAdicionarAtualizarActionPerformed
        pCarregar.setVisible(true);
        if(atualizarDeletar==false){
            
            adicionarObjetivo();
        }
        else{
            atualizarNoBD();
        }
               
    }//GEN-LAST:event_bAdicionarAtualizarActionPerformed
    
    public void adicionarObjetivo(){        

        if(pegarDatas()){
            //O usuário pode escolher se irá querer adicionar o dinheiro mensal que ele selecionou de uma vez
            /*O dia da cobrança automatica começa a contar a partir do próximo mês, pois entende-se que o usuário ou já tem um deinheiro guardado, 
            que irá para o caixa, ou está esperando para receber seu pagamento*/
            
            double preco=Double.parseDouble(jFormattedTextFieldPreco.getText().replaceAll(",","."));
            double caixa=Double.parseDouble(jFormattedTextFieldCaixa.getText().replaceAll(",","."));
            double aporte_mensal=Double.parseDouble(jFormattedTextFieldAporte_Mensal.getText().replaceAll(",","."));
            LocalDate data_para_adicionar_no_caixa = null;
            if(guardar_no_dia){
                data_para_adicionar_no_caixa = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), Integer.parseInt(tData1.getText()));
            }
            else{
                data_para_adicionar_no_caixa = LocalDate.now();
            }
            Objetivos nova =null;
            try{
                nova = new Objetivos((objetivos.get(0).getIdObjetivo()+1),jTextFieldMeta.getText(),u.getCpf(), preco, caixa, aporte_mensal,data,data_para_adicionar_no_caixa.plusMonths(1) ,guardar_no_dia);
            }catch(Exception e){
                nova = new Objetivos(1,jTextFieldMeta.getText(),u.getCpf(), preco, caixa, aporte_mensal,data,data_para_adicionar_no_caixa.plusMonths(1) ,guardar_no_dia);
            }
            
            if(!objetivos.isEmpty()){
                ArrayList<Objetivos>objetivosTemporario=new ArrayList<Objetivos>();
                for(int i=0; i<objetivos.size(); i++){
                   
                    objetivosTemporario.add(objetivos.get(i));
                }
                for(int i=0;i<objetivos.size();i++){
                    objetivos.remove(0);
                }
                objetivos.add(nova);
                for(int i=1;i<objetivosTemporario.size();i++){
                    objetivos.add(objetivosTemporario.get(i-1));
                }
                objetivos.add(objetivosTemporario.get(objetivosTemporario.size()-1));
            }
            else{
                objetivos.add(nova);
            }
               
            
            DAOObjetivos adicionar = new DAOObjetivos();
            boolean adicaoFeita = adicionar.inserirNoBD(nova);
            
            
            //Caso o usuário queira, a partir do próximo mês, o dinheiro já será contado automaticamente no dia em que ele marcou
            String auto_adicionar = "Não";
            String dia_auto_adicionar = "Não definida";
            if(guardar_no_dia){
                auto_adicionar="Sim";
                dia_auto_adicionar = data_para_adicionar_no_caixa.getDayOfMonth()+"";
            }
            if(adicaoFeita){
                tabela.addRow(new Object[]{jTextFieldMeta.getText(),"R$ "+preco, "R$ "+caixa, "R$ "+aporte_mensal,data.format(formato),auto_adicionar,dia_auto_adicionar }); 
                tabela.moveRow(tabela.getRowCount()-1, tabela.getRowCount()-1,0);
                JOptionPane.showMessageDialog(null, "Inserção feita com sucesso");
            }
            else{
                objetivos.remove(nova);
                JOptionPane.showMessageDialog(null, "Erro! Tente novamente mais tarde", "Erro", JOptionPane.ERROR_MESSAGE);
            }
                
            apagarTodasEscritas();
        }
            
    }
    
    public void atualizarNoBD(){        
        boolean dataValida = pegarDatas();
        
        if(dataValida){
            double preco=Double.parseDouble(jFormattedTextFieldPreco.getText().replaceAll(",","."));
            double caixa=Double.parseDouble(jFormattedTextFieldCaixa.getText().replaceAll(",","."));
            double aporte_mensal=Double.parseDouble(jFormattedTextFieldAporte_Mensal.getText().replaceAll(",",".")); 
            
            LocalDate data_para_adicionar_no_caixa = null;
            if(guardar_no_dia){
                data_para_adicionar_no_caixa = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), Integer.parseInt(tData1.getText()));
            }
            else{
                data_para_adicionar_no_caixa = LocalDate.now();
            }
           
            
            objetivos.get(linhaSelected).setMeta(jTextFieldMeta.getText());
            objetivos.get(linhaSelected).setPreco(preco);
            objetivos.get(linhaSelected).setCaixa(caixa);
            objetivos.get(linhaSelected).setAporte_mensal(aporte_mensal);
            objetivos.get(linhaSelected).setData_estimada(data);
            objetivos.get(linhaSelected).setAdicionar_no_caixa(guardar_no_dia);
            objetivos.get(linhaSelected).setData_adicionar_no_caixa(data_para_adicionar_no_caixa);


            boolean atualizacaoFeita = objetivosBD.atualizarNoBD( objetivos.get(linhaSelected));
            
            String auto_adicionar = "Não";
            String dia_auto_adicionar = "Não definida";
            if(guardar_no_dia){
                auto_adicionar="Sim";
                dia_auto_adicionar = data_para_adicionar_no_caixa.getDayOfMonth()+"";
            }
            
            if(atualizacaoFeita){
                tabela.setValueAt(objetivos.get(linhaSelected).getMeta(), linhaSelected,0);
                tabela.setValueAt("R$ "+objetivos.get(linhaSelected).getPreco(), linhaSelected,1);
                tabela.setValueAt("R$ "+objetivos.get(linhaSelected).getCaixa(), linhaSelected,2);
                tabela.setValueAt("R$ "+objetivos.get(linhaSelected).getAporte_mensal(), linhaSelected,3);
                tabela.setValueAt(data.format(formato), linhaSelected,4);
                tabela.setValueAt(auto_adicionar, linhaSelected,5);
                tabela.setValueAt(dia_auto_adicionar, linhaSelected,6);
                JOptionPane.showMessageDialog(null, "Alteração de dados realizada com sucesso!");
            }
            else{
                JOptionPane.showMessageDialog(null, "Ocorreu um erro! Tente novamente mais tarde", "Erro", JOptionPane.ERROR_MESSAGE);
            }
                
        }
        apagarTodasEscritas();

    }
    
    public boolean pegarDatas(){
        //Os valores de datas são pegos e mandados para a variavel data ao mesmo tempo que verifica se ela é válida
        try{
            String dataLida[] = tData.getText().split("/");
            int dia = Integer.parseInt(dataLida[0]);
            int mes = Integer.parseInt(dataLida[1]);
            int ano = Integer.parseInt(dataLida[2]);
            data = LocalDate.of(ano, mes, dia);
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data ou horário inválido", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        apagarTodasEscritas();
    }//GEN-LAST:event_bCancelarActionPerformed

    private void apagarTodasEscritas(){
        //Apaga tudo que está nos jTextField
        atualizarDeletar=false;
        bDeletar.setVisible(atualizarDeletar);
        bAdicionarAtualizar.setText("Adicionar");
        jTextFieldMeta.setText(null);
        jFormattedTextFieldPreco.setText("0,00");
        jFormattedTextFieldCaixa.setText("0,00");
        jFormattedTextFieldAporte_Mensal.setText("0,00");
        tData.setText(null);
        jTextFieldMeta.setEditable(true);
        guardar_no_dia = true;
        bSim.setBackground(Color.green);
        bNao.setBackground(Color.gray);
        tData1.setText(null);
        
        pCarregar.setVisible(false);
    }
    
    private void bDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeletarActionPerformed
        //O saldo do usuario tem que voltar ao normal como se aquela transação nuca tivesse acontecido
        pCarregar.setVisible(true);
        boolean apagouMovimentacao = false;
        if(objetivos.get(linhaSelected).isAdicionar_no_caixa()){
            u.setSaldo(objetivos.get(linhaSelected).getCaixa());
            DAOUsuario atualizarUsuario = new DAOUsuario();
            atualizarUsuario.atualizarSaldo(u);
            DAOMovimentacoes movimentacoes = new DAOMovimentacoes();
            apagouMovimentacao = movimentacoes.deletarMovimentacaoDeObjetivos(u.getCpf(), objetivos.get(linhaSelected).getIdObjetivo());
        }
        else{
            apagouMovimentacao = true;
        }
        
        if(apagouMovimentacao){
            boolean remocaoFeita = objetivosBD.deletarNoBD(objetivos.get(linhaSelected).getCpf(), objetivos.get(linhaSelected).getIdObjetivo());
            if(remocaoFeita){
                tabela.removeRow(linhaSelected);
                objetivos.remove(linhaSelected);
                apagarTodasEscritas();
                JOptionPane.showMessageDialog(null, "Remoção feita com sucesso!");
            }
            else{
                JOptionPane.showMessageDialog(null, "Houve algum problema! Tente novamente mais tarde", "ERRO", JOptionPane.ERROR_MESSAGE);
                pCarregar.setVisible(false);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Houve algum problema ao apagar das movimentações! Tente novamente mais tarde", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
            
            

    }//GEN-LAST:event_bDeletarActionPerformed

    private void bCalcularDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCalcularDataActionPerformed
        double preco=Double.parseDouble(jFormattedTextFieldPreco.getText().replaceAll(",","."));
        double caixa=Double.parseDouble(jFormattedTextFieldCaixa.getText().replaceAll(",","."));
        double guardar_mensalmente=Double.parseDouble(jFormattedTextFieldAporte_Mensal.getText().replaceAll(",","."));
        
        
        LocalDate dataAtual =LocalDate.now();
        
        double mes =(preco-caixa)/guardar_mensalmente;
        int mesArredondado=(int) mes;
        int meses=0;
        if((mes-mesArredondado)>0){
            meses=1;
        }
        tData.setText(""+dataAtual.plusMonths((mesArredondado+meses)).format(formato));
    }//GEN-LAST:event_bCalcularDataActionPerformed

    private void bCalcularDinheiroMensalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCalcularDinheiroMensalActionPerformed
        //Descobre quanto o usuario deve juntar por mes para conseguir cumprir sua meta até a data estipuada por ele
        double preco=Double.parseDouble(jFormattedTextFieldPreco.getText().replaceAll(",","."));
        double caixa=Double.parseDouble(jFormattedTextFieldCaixa.getText().replaceAll(",","."));
        LocalDate dataAtual =LocalDate.now();
        boolean dataValida = pegarDatas();
        if(dataValida){
            double guardarMensalmente = (preco - caixa)/(dataAtual.until(data, ChronoUnit.MONTHS));
            jFormattedTextFieldAporte_Mensal.setText(""+guardarMensalmente);
        }
        
        
    }//GEN-LAST:event_bCalcularDinheiroMensalActionPerformed

    private void bSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSimActionPerformed
        guardar_no_dia = true;
        bSim.setBackground(Color.green);
        bNao.setBackground(Color.gray);
    }//GEN-LAST:event_bSimActionPerformed

    private void bNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNaoActionPerformed
        guardar_no_dia = false;
        tData1.setText("");
        bSim.setBackground(Color.gray);
        bNao.setBackground(Color.green);
    }//GEN-LAST:event_bNaoActionPerformed

    private void tData1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tData1FocusGained
        if(guardar_no_dia){
            tData1.setEditable(true);
        }
        else{
            tData1.setEditable(false);
        }
    }//GEN-LAST:event_tData1FocusGained

    private void tData1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tData1KeyTyped
        int limite=2;
        if(tData1.getText().length()>=limite){
          evt.consume();
        }
    }//GEN-LAST:event_tData1KeyTyped

    private void tData1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tData1KeyReleased
        tData1.setText(tData1.getText().replaceAll("[^0-9]", ""));
    }//GEN-LAST:event_tData1KeyReleased

    private void jTextFieldMetaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMetaKeyTyped
        int limite=100;
        if(jTextFieldMeta.getText().length()>=limite){
          evt.consume();
        }
    }//GEN-LAST:event_jTextFieldMetaKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela_Objetivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Objetivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Objetivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Objetivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_Objetivos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAdicionarAtualizar;
    private javax.swing.JButton bCalcularData;
    private javax.swing.JButton bCalcularDinheiroMensal;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bDeletar;
    private javax.swing.JButton bNao;
    private javax.swing.JButton bSim;
    private javax.swing.JButton bVoltar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JFormattedTextField jFormattedTextFieldAporte_Mensal;
    private javax.swing.JFormattedTextField jFormattedTextFieldCaixa;
    private javax.swing.JFormattedTextField jFormattedTextFieldPreco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextFieldMeta;
    private javax.swing.JPanel pCarregar;
    private javax.swing.JFormattedTextField tData;
    private javax.swing.JTextField tData1;
    // End of variables declaration//GEN-END:variables
}
