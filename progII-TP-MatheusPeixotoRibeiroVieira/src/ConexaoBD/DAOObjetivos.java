/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoBD;

import Objetos.Movimentacoes;
import Objetos.Objetivos;
import Objetos.Usuario;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Matheus
 */
public class DAOObjetivos {
    public ArrayList pegarObjetivos(Usuario u){
        ArrayList<Objetivos> retorno =new ArrayList<Objetivos>();
        Conectar conexao = new Conectar();
        
        try{
            conexao.checarConexao();
            String sql = "SELECT * FROM objetivos WHERE cpf= '"+u.getCpf()+"' ORDER BY idobjetivo DESC";
            PreparedStatement ps = conexao.c.prepareStatement(sql); 
            ResultSet r= ps.executeQuery();
            while(r.next()){
                //String meta, String cpf, double valor, double caixa, double dinheiro_mensal, LocalDate data_estimada
                retorno.add(new Objetivos (r.getInt("idobjetivo"), r.getString("meta"),r.getString("cpf"),r.getDouble("preco"),r.getDouble("caixa"),r.getDouble("aportes_futuros"),r.getDate("data_estimada").toLocalDate(), r.getDate("data_adicionar_no_caixa").toLocalDate(),r.getBoolean("adicionar_no_caixa")));
                //System.out.println("idObjetivo: "+r.getInt("idobjetivo"));
            }
            return retorno;
            
        }catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ocorreu um erro, tente novamente mais tarde", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        } 
    }
    public int pegarValorEmCaixa(String cpf, int idobjetivo){
        Conectar conexao = new Conectar();
        try{
            conexao.checarConexao();
            String sql = "SELECT caixa FROM objetivos WHERE cpf= '"+cpf+"' AND idobjetivo='"+idobjetivo+"';";
            PreparedStatement ps = conexao.c.prepareStatement(sql); 
            ResultSet r= ps.executeQuery();
            int retorno=-9;
            while(r.next()){
                retorno = r.getInt("caixa");
            }
            
            return retorno;
        }catch(Exception ex){
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ocorreu um erro, tente novamente mais tarde", "Erro", JOptionPane.ERROR_MESSAGE);
            return -80000;
        }
        
    }
    
    public boolean inserirNoBD(Objetivos o){
        Conectar conexao = new Conectar();
        try{
            conexao.checarConexao();
            String sql = "INSERT INTO objetivos (idobjetivo, meta, cpf, caixa, aportes_futuros, preco, data_estimada, data_adicionar_no_caixa, adicionar_no_caixa) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";                                       
            PreparedStatement ps =conexao.c.prepareStatement(sql);
            ps.setInt(1, o.getIdObjetivo());
            ps.setString(2, o.getMeta());
            ps.setString(3, o.getCpf());
            ps.setDouble(4, o.getCaixa());
            ps.setDouble(5, o.getAporte_mensal());
            ps.setDouble(6, o.getPreco());
            ps.setDate(7, Date.valueOf(o.getData_estimada()));
            ps.setDate(8, Date.valueOf(o.getData_adicionar_no_caixa()));
            ps.setBoolean(9, o.isAdicionar_no_caixa());
            ps.execute();
            conexao.c.close();
            return true;

            
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            conexao.fechaConexao();
            return false;
        }
    }
    
    public boolean deletarNoBD(String cpf, int idObjetivo){
        Conectar conexao= new Conectar();
        
        try{
            conexao.checarConexao();
            Statement s =conexao.c.createStatement();
            String sql="DELETE FROM objetivos WHERE cpf='"+cpf+"' AND idobjetivo='"+idObjetivo+"' ;";
            s.execute(sql);
            conexao.c.close();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            conexao.fechaConexao();
            return false;
        }
    }
    
    public boolean atualizarNoBD(Objetivos o){
       Conectar conexao = new Conectar();
        try{
            conexao.checarConexao();
            String sql = "UPDATE objetivos SET meta = ?, caixa= ?, aportes_futuros= ?, preco= ?, data_estimada= ?, data_adicionar_no_caixa= ?, adicionar_no_caixa = ? WHERE cpf = ? AND idobjetivo = ?; ";
            //String sql = "UPDATE objetivos SET caixa= ?, aportes_futuros= ?, preco= ?, data_estimada= ? WHERE cpf = ? AND meta = ?; ";
            PreparedStatement ps = conexao.c.prepareStatement(sql);
            ps.setString(1,o.getMeta());
            ps.setDouble(2, o.getCaixa());
            ps.setDouble(3, o.getAporte_mensal());
            ps.setDouble(4, o.getPreco());
            ps.setDate(5, Date.valueOf(o.getData_estimada()));
            ps.setDate(6, Date.valueOf(o.getData_adicionar_no_caixa()));
            ps.setBoolean(7, o.isAdicionar_no_caixa());
            ps.setString(8, o.getCpf());
            ps.setInt(9, o.getIdObjetivo());
            ps.execute();
            conexao.fechaConexao();
            return true;
            
        }catch(Exception ex){
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            conexao.fechaConexao();
            return false;
        }
    }
    
    public boolean atualizarPelaTela_Movimentacoes(double caixa, String cpf, int idObjetivo){
       Conectar conexao = new Conectar();
        try{
            conexao.checarConexao();
            String sql = "UPDATE objetivos SET caixa= ? WHERE cpf = ? AND idobjetivo = ?; ";
            //String sql = "UPDATE objetivos SET caixa= ?, aportes_futuros= ?, preco= ?, data_estimada= ? WHERE cpf = ? AND meta = ?; ";
            PreparedStatement ps = conexao.c.prepareStatement(sql);
            ps.setDouble(1, caixa);
            ps.setString(2, cpf);
            ps.setInt(3, idObjetivo);
            ps.execute();
            conexao.fechaConexao();
            return true;
            
        }catch(Exception ex){
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            conexao.fechaConexao();
            return false;
        }
    }
}
