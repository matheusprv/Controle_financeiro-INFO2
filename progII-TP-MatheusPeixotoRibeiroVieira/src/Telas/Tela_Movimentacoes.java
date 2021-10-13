/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import ConexaoBD.DAOMovimentacoes;
import ConexaoBD.DAOObjetivos;
import ConexaoBD.DAOUsuario;
import Objetos.Movimentacoes;
import Objetos.Usuario;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Matheus
 */
public class Tela_Movimentacoes extends javax.swing.JFrame {
    Usuario u;
    ArrayList<Movimentacoes> movimentos =new ArrayList<Movimentacoes>();
    DefaultTableModel tabela;
    boolean atualizarDeletar = false; //Muda para atualizarDeletar, caso clique no jTable 
    int linhaSelected=0;
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
    LocalDate data = null;
    LocalTime hora = null;
    DAOObjetivos daoobjetivos = new DAOObjetivos();
    String filtroAtual = "Todos";
    
    public Tela_Movimentacoes(Usuario usuario) {
        initComponents();
        u= usuario;
        
        tabela = (DefaultTableModel) jTable.getModel();
        tabela.setColumnCount(5);
        tabela.isCellEditable(WIDTH, WIDTH);
        
        bCancelar.setVisible(atualizarDeletar);//Esses dois botões só aparecem quando o usuário for atualizarDeletar ou deletar algo após clicar no item na jTable
        bDeletar.setVisible(atualizarDeletar);
        
        rInvisivel.setVisible(false);
    }

    private Tela_Movimentacoes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoPagarReceber = new javax.swing.ButtonGroup();
        pCarregar = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tMotivo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        tNome = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        bVoltar = new javax.swing.JButton();
        rPagar = new javax.swing.JRadioButton();
        rReceber = new javax.swing.JRadioButton();
        tData = new javax.swing.JFormattedTextField();
        tHorario = new javax.swing.JFormattedTextField();
        tValor = new javax.swing.JFormattedTextField();
        bDeletar = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        bAdicionarAtualizar = new javax.swing.JButton();
        tSaldo = new javax.swing.JLabel();
        rInvisivel = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        cbFiltragem = new javax.swing.JComboBox<>();
        bFiltrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Movimentações");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pCarregar.setBackground(new java.awt.Color(204, 204, 204));
        pCarregar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Carregando... Por favor aguarde.");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Isso pode demorar um pouco...");

        javax.swing.GroupLayout pCarregarLayout = new javax.swing.GroupLayout(pCarregar);
        pCarregar.setLayout(pCarregarLayout);
        pCarregarLayout.setHorizontalGroup(
            pCarregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCarregarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pCarregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pCarregarLayout.setVerticalGroup(
            pCarregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCarregarLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pCarregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 220, 60));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Motivo: ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 51, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Valor: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 101, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Data: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 151, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Horario: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 197, -1, -1));

        tMotivo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tMotivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tMotivoKeyTyped(evt);
            }
        });
        getContentPane().add(tMotivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 42, 200, 38));

        jTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Motivo", "Valor", "Data", "Hora", "Pagar/Receber"
            }
        ));
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 284, 538, 227));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Olá, ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 10, -1, -1));

        tNome.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tNome.setText("Nome_Do_Usuario");
        getContentPane().add(tNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 10, 388, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Saldo:  R$");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 10, -1, -1));

        bVoltar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bVoltar.setText("Voltar");
        bVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(bVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        grupoPagarReceber.add(rPagar);
        rPagar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rPagar.setText("Pagamento");
        getContentPane().add(rPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 253, -1, -1));

        grupoPagarReceber.add(rReceber);
        rReceber.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rReceber.setText("Recebeu");
        getContentPane().add(rReceber, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 253, -1, -1));

        try {
            tData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(tData, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 142, 200, 38));

        try {
            tHorario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(tHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 188, 200, 38));

        tValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###0.00"))));
        tValor.setText("0,00");
        getContentPane().add(tValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 92, 199, 38));

        bDeletar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bDeletar.setText("Deletar");
        bDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeletarActionPerformed(evt);
            }
        });
        getContentPane().add(bDeletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 92, 96, -1));

        bCancelar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(bCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 42, -1, -1));

        bAdicionarAtualizar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bAdicionarAtualizar.setText("Adicionar");
        bAdicionarAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAdicionarAtualizarActionPerformed(evt);
            }
        });
        getContentPane().add(bAdicionarAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 42, -1, -1));

        tSaldo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(tSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 10, 115, 19));

        grupoPagarReceber.add(rInvisivel);
        rInvisivel.setText("Botão invisível ");
        getContentPane().add(rInvisivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 254, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setText("Filtrar: ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 149, -1, -1));

        cbFiltragem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Movimentações", "Objetivos" }));
        getContentPane().add(cbFiltragem, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 150, -1, -1));

        bFiltrar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        bFiltrar.setText("Filtrar");
        bFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFiltrarActionPerformed(evt);
            }
        });
        getContentPane().add(bFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 186, 153, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVoltarActionPerformed
        Tela_opcoes abrir = new Tela_opcoes(u);
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bVoltarActionPerformed
        
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        LocalDate dataAtual =LocalDate.now();
        tData.setText(""+dataAtual.format(formato));
        
        LocalTime horaAtual = LocalTime.now();
        tHorario.setText(""+horaAtual.format(formatoHora));
        
        tNome.setText(u.getNome());
        String valorEmTexto= ""+u.getSaldo();
        tSaldo.setText("R$ "+valorEmTexto);
        DAOMovimentacoes movimentosVetor= new DAOMovimentacoes();
        
        movimentos =movimentosVetor.pegarTodasMovimentacoes(u);

        if(movimentos!=null){   
            for(Movimentacoes mov: movimentos){
                String pagarReceber;
                if(mov.isRecebeu()){
                    pagarReceber= "Recebeu";
                }
                else{
                    pagarReceber= "Pagar";
                }
                tabela.addRow(new Object[]{mov.getMotivo(),"R$ "+mov.getValor(),mov.getData().format(formato),mov.getHora(),pagarReceber}); 
            }
            
        }
        pCarregar.setVisible(false);
    }//GEN-LAST:event_formWindowOpened
    
    
    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        
        linhaSelected = jTable.getSelectedRow();
        System.out.println(linhaSelected);
                
        tMotivo.setText(movimentos.get(linhaSelected).getMotivo());
        tValor.setText(""+movimentos.get(linhaSelected).getValor());
        tData.setText(""+movimentos.get(linhaSelected).getData().format(formato));
        tHorario.setText(""+movimentos.get(linhaSelected).getHora());
        if(movimentos.get(linhaSelected).isRecebeu()){
            rReceber.setSelected(true);
        }
        else{
            rPagar.setSelected(true);
        }
        atualizarDeletar=true;
        bAdicionarAtualizar.setText("Atualizar");
        bCancelar.setVisible(atualizarDeletar);
        bDeletar.setVisible(atualizarDeletar);
        
        
    }//GEN-LAST:event_jTableMouseClicked

    private void bAdicionarAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAdicionarAtualizarActionPerformed
        pCarregar.setVisible(true);
        boolean radiosSelecionados=false;
        if(rPagar.isSelected()==true || rReceber.isSelected()==true){
            radiosSelecionados=true;
        }
        //System.out.println(jTextFieldMotivo.getText());
        if(radiosSelecionados==false){
            pCarregar.setVisible(false);
            JOptionPane.showMessageDialog(null, "Não é possível salvar sem selecionar se é pagamento ou recebimento", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        else{
            
            if(atualizarDeletar==false){
                adicionarMovimentacao();
            }
            else{
                atualizarNoBD();
            }
        }        
    }//GEN-LAST:event_bAdicionarAtualizarActionPerformed
    
    public void adicionarMovimentacao(){        

        //int proximaMovimentacao=movimentos.get(0).getNumero_movimentacao()+1;
        
        boolean dataHoraValido=pegarDataHora(); // Verifica se a data e hora são válidas

        if(dataHoraValido){
            double valor=Double.parseDouble(tValor.getText().replaceAll(",","."));
            String recebeuString=null;
            boolean recebeu;
            if(rPagar.isSelected()){
                recebeu=false;
                u.setSaldo(-valor);
                recebeuString="Pagamento";
            }
            else{
                recebeu=true;
                u.setSaldo(valor);
                recebeuString="Recebeu";
            }
            Movimentacoes nova = null;
            try{
                nova = new Movimentacoes(u.getCpf(),tMotivo.getText(),movimentos.get(0).getNumero_movimentacao()+1,valor,data,hora,recebeu, 0);
            }catch(Exception e){
                nova = new Movimentacoes(u.getCpf(),tMotivo.getText(),1,valor,data,hora,recebeu, 0);
            }
            if(movimentos.size()!=0){
                ArrayList<Movimentacoes>movimentacoesTemporario = new ArrayList<Movimentacoes>();
                for(int i=0; i<movimentos.size(); i++){
                    //System.out.println(movimentos.get(i).getNumero_movimentacao());
                    
                    movimentacoesTemporario.add(movimentos.get(i));
                }
                for(int i=0;i<movimentos.size();i++){
                    movimentos.remove(0);
                }
                movimentos.add(nova);
                for(int i=1;i<movimentacoesTemporario.size();i++){
                    movimentos.add(movimentacoesTemporario.get(i-1));
                }
                movimentos.add(movimentacoesTemporario.get(movimentacoesTemporario.size()-1));
            }            
            movimentos.add(nova);

            DAOMovimentacoes adicionar = new DAOMovimentacoes();        
            boolean insercaoCerta = adicionar.inserirNoBD(nova);
            DAOUsuario atualizarSaldo = new DAOUsuario();
            boolean alteracaoUsuarioCerta = atualizarSaldo.atualizarSaldo(u);

            if(insercaoCerta && alteracaoUsuarioCerta){
                tabela.addRow(new Object[]{tMotivo.getText(),"R$ "+valor,data.format(formato),hora, recebeuString}); 
                tabela.moveRow(tabela.getRowCount()-1, tabela.getRowCount()-1,0);
                apagarTodasEscritas();
                JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso");
            }
            else{
                JOptionPane.showMessageDialog(null, "Ocorreu um erro! Tente novamente mais tarde", "ERRO", JOptionPane.ERROR_MESSAGE);
                movimentos.remove(nova);
            }
        }

            
    }
    
    public void atualizarNoBD(){
        double valorNovo=Double.parseDouble(tValor.getText().replaceAll(",","."));//Valor da transação atualizado
        double valorAntigo=movimentos.get(linhaSelected).getValor(); //Valor antigo da transação do cliente
        boolean recebeuAntigo = movimentos.get(linhaSelected).isRecebeu(); //Se ele recebeu ou pagou. true para recebeu e false para pagou
        boolean recebeuNovo=true;
        
        boolean datavalida = pegarDataHora();// Verifica se a data e hora são válidas
        if(datavalida){
            if(movimentos.get(linhaSelected).getIdobjetivo() == 0){
                if(rPagar.isSelected()){
                    recebeuNovo=false;
                }

                if(valorAntigo!=valorNovo && recebeuNovo != recebeuAntigo){
                    if(recebeuNovo && recebeuAntigo==false){
                        //Era um pagamento que na verdade era para ser um recebimento
                        u.setSaldo(valorAntigo+valorNovo); //ESTÁ FUNCIONANDO CORRETAMENTE
                    }
                    else{
                        //Era um recebimento que na verdade era para ser um pagamento
                        u.setSaldo(-valorAntigo-valorNovo);
                    }
                }
                else if(valorAntigo!=valorNovo && recebeuNovo == recebeuAntigo){                
                    //Somente o valor que estava errado 
                    u.setSaldo(valorNovo-valorAntigo);                   
                }
                else if(valorAntigo==valorNovo && recebeuNovo != recebeuAntigo){
                    if(recebeuNovo){
                        //Pagamento que na verdade era recebimento
                        u.setSaldo(2*valorAntigo);
                    }
                    else{
                        //Recebimento que na verdade era pagamento
                        u.setSaldo(-2*valorAntigo);
                    }
                }
                
            }
            else{
                if(valorNovo>valorAntigo){
                    u.setSaldo(valorNovo-valorAntigo);
                    double valores = valorAntigo+(valorNovo-valorAntigo);
                    daoobjetivos.atualizarPelaTela_Movimentacoes(valores, u.getCpf(), movimentos.get(linhaSelected).getIdobjetivo());
                }
                else{
                    double valores = valorAntigo - (valorAntigo - valorNovo);
                    u.setSaldo(valorNovo-valorAntigo);
                    daoobjetivos.atualizarPelaTela_Movimentacoes(valores, u.getCpf(), movimentos.get(linhaSelected).getIdobjetivo());
                }
            }

            movimentos.get(linhaSelected).setMotivo(tMotivo.getText());
            movimentos.get(linhaSelected).setValor(valorNovo);
            movimentos.get(linhaSelected).setData(data);
            movimentos.get(linhaSelected).setHora(hora);
            movimentos.get(linhaSelected).setRecebeu(recebeuNovo);

            DAOMovimentacoes movimentacoes = new DAOMovimentacoes();
            boolean atualizacaoFeita = movimentacoes.atualizarNoBD(movimentos.get(linhaSelected));
            
            DAOUsuario usuario = new DAOUsuario();
            boolean atualizacaoSaldoFeita =usuario.atualizarSaldo(u);
            if(atualizacaoFeita && atualizacaoSaldoFeita){
                String recebeuPagou="Pagamento";
                if(movimentos.get(linhaSelected).isRecebeu()){
                    recebeuPagou="Recebeu";
                }
                tabela.setValueAt(movimentos.get(linhaSelected).getMotivo(), linhaSelected,0);
                tabela.setValueAt("R$ "+movimentos.get(linhaSelected).getValor(), linhaSelected,1);
                tabela.setValueAt(movimentos.get(linhaSelected).getData().format(formato), linhaSelected,2);
                tabela.setValueAt(movimentos.get(linhaSelected).getHora().format(formatoHora), linhaSelected,3);
                tabela.setValueAt(recebeuPagou, linhaSelected,4);
                tSaldo.setText(u.getSaldo()+"");
                JOptionPane.showMessageDialog(null, "Alteração de dados realizada com sucesso!");
            }
            else{
                JOptionPane.showMessageDialog(null, "Ocorreu um erro! Tente novamente mais tarde.", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
        apagarTodasEscritas();
            
    }
    
    public boolean pegarDataHora(){
        try{
            String dataLida[] = tData.getText().split("/");
            int dia = Integer.parseInt(dataLida[0]);
            int mes = Integer.parseInt(dataLida[1]);
            int ano = Integer.parseInt(dataLida[2]);
            data = LocalDate.of(ano, mes, dia);
            //System.out.println("data frmatada: "+data.format(formato));
            
            
            String horaLida[] = tHorario.getText().split(":");
            int horas = Integer.parseInt(horaLida[0]);
            int minutos = Integer.parseInt(horaLida[1]);
            hora = LocalTime.of(horas, minutos);
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
        LocalDate dataAtual =LocalDate.now();
        tData.setText(""+dataAtual.format(formato));
        
        LocalTime horaAtual = LocalTime.now();
        tHorario.setText(""+horaAtual.format(formatoHora));
        
        atualizarDeletar=false;
        bCancelar.setVisible(atualizarDeletar);
        bDeletar.setVisible(atualizarDeletar);
        bAdicionarAtualizar.setText("Adicionar");
        tMotivo.setText(null);
        tValor.setText(null);
        rInvisivel.setSelected(true);
        rPagar.setSelected(false);
        rReceber.setSelected(false);
        
        tSaldo.setText(""+u.getSaldo());
        
        pCarregar.setVisible(false);
    }
    
    private void bDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeletarActionPerformed
        //O saldo do usuario tem que voltar ao normal como se aquela transação nuca tivesse acontecido
        pCarregar.setVisible(true);
        double valor=Double.parseDouble(tValor.getText().replaceAll(",","."));
        if(movimentos.get(linhaSelected).getIdobjetivo() == 0){
            if(rPagar.isSelected()){
                u.setSaldo(valor);
            }
            else{
                u.setSaldo(-valor);
            }
        }
        else{
            u.setSaldo(valor);
            int caixa = daoobjetivos.pegarValorEmCaixa(u.getCpf(), movimentos.get(linhaSelected).getIdobjetivo());
            daoobjetivos.atualizarPelaTela_Movimentacoes((caixa-valor), u.getCpf(), movimentos.get(linhaSelected).getIdobjetivo());
        }
            
        DAOUsuario atualizarSaldo = new DAOUsuario();
        atualizarSaldo.atualizarSaldo(u);
        
        DAOMovimentacoes m= new DAOMovimentacoes();
        m.deletarNoBD(movimentos.get(linhaSelected).getCPF(), movimentos.get(linhaSelected).getNumero_movimentacao());
        tabela.removeRow(linhaSelected);
        movimentos.remove(linhaSelected);
        apagarTodasEscritas();

    }//GEN-LAST:event_bDeletarActionPerformed

    private void bFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFiltrarActionPerformed
        String novoFiltro =(String) cbFiltragem.getSelectedItem();
        for(int i=0;i<movimentos.size();i++){
            movimentos.remove(0);
        }
        for(int i=tabela.getRowCount()-1; i>=0;i--){
            tabela.removeRow(i);
        }

        LocalDate dataAtual =LocalDate.now();
        tData.setText(""+dataAtual.format(formato));

        LocalTime horaAtual = LocalTime.now();
        tHorario.setText(""+horaAtual.format(formatoHora));

        tNome.setText(u.getNome());
        String valorEmTexto= ""+u.getSaldo();
        tSaldo.setText("R$ "+valorEmTexto);
        DAOMovimentacoes movimentosVetor= new DAOMovimentacoes();

        if(novoFiltro.equals("Todos")){
            movimentos =movimentosVetor.pegarTodasMovimentacoes(u);
        }
        else if(novoFiltro.equals("Movimentações")){
            movimentos =movimentosVetor.pegarSomenteMovimentacoes(u);
        }
        else{
            movimentos =movimentosVetor.pegarMovimentacoesDeObjetivos(u);
        }

        if(movimentos!=null){            
            for(Movimentacoes mov: movimentos){
                String pagarReceber;
                if(mov.isRecebeu()){
                    pagarReceber= "Recebeu";
                }
                else{
                    pagarReceber= "Pagar";
                }
                tabela.addRow(new Object[]{mov.getMotivo(),"R$ "+mov.getValor(),mov.getData().format(formato),mov.getHora(),pagarReceber}); 
            }
        }

        apagarTodasEscritas();
    }//GEN-LAST:event_bFiltrarActionPerformed
    public void adicionarNaTabela(){
        
    }
    
    
    private void tMotivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tMotivoKeyTyped
        int limite=100;
        if(tMotivo.getText().length()>=limite){
          evt.consume();
        }
    }//GEN-LAST:event_tMotivoKeyTyped
 
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
            java.util.logging.Logger.getLogger(Tela_Movimentacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Movimentacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Movimentacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Movimentacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_Movimentacoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAdicionarAtualizar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bDeletar;
    private javax.swing.JButton bFiltrar;
    private javax.swing.JButton bVoltar;
    private javax.swing.JComboBox<String> cbFiltragem;
    private javax.swing.ButtonGroup grupoPagarReceber;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JPanel pCarregar;
    private javax.swing.JRadioButton rInvisivel;
    private javax.swing.JRadioButton rPagar;
    private javax.swing.JRadioButton rReceber;
    private javax.swing.JFormattedTextField tData;
    private javax.swing.JFormattedTextField tHorario;
    private javax.swing.JTextField tMotivo;
    private javax.swing.JLabel tNome;
    private javax.swing.JLabel tSaldo;
    private javax.swing.JFormattedTextField tValor;
    // End of variables declaration//GEN-END:variables
}
