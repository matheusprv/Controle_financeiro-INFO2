/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoBD;

import Objetos.Movimentacoes;
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
public class DAOMovimentacoes {
    public ArrayList pegarTodasMovimentacoes(Usuario u){
        ArrayList<Movimentacoes> retorno =new ArrayList<Movimentacoes>();
        Conectar conexao = new Conectar();
        
        try{
            conexao.checarConexao();
            String sql = "SELECT * FROM movimentacoes WHERE cpf= '"+u.getCpf()+"' ORDER BY numero_da_movimentacao DESC";
            //String sql = "SELECT * FROM movimentacoes WHERE cpf= '"+u.getCpf()+"'";
            PreparedStatement ps = conexao.c.prepareStatement(sql); 
            ResultSet r= ps.executeQuery();
            while(r.next()){
                retorno.add(new Movimentacoes(r.getString("cpf"),r.getString("motivo"),r.getInt("numero_da_movimentacao"),r.getDouble("valor"),r.getDate("data").toLocalDate(),r.getTime("hora").toLocalTime(), r.getBoolean("recebeu"), r.getInt("idobjetivo")));
            }
            return retorno;
            
        }catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ocorreu um erro, tente novamente mais tarde", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        } 
    }
    
    public ArrayList pegarSomenteMovimentacoes(Usuario u){
        ArrayList<Movimentacoes> retorno =new ArrayList<Movimentacoes>();
        Conectar conexao = new Conectar();
        
        try{
            conexao.checarConexao();
            String sql = "SELECT * FROM movimentacoes WHERE cpf= '"+u.getCpf()+"' ORDER BY numero_da_movimentacao DESC";
            //String sql = "SELECT * FROM movimentacoes WHERE cpf= '"+u.getCpf()+"'";
            PreparedStatement ps = conexao.c.prepareStatement(sql); 
            ResultSet r= ps.executeQuery();
            while(r.next()){
                if(r.getInt("idobjetivo")==0){
                    retorno.add(new Movimentacoes(r.getString("cpf"),r.getString("motivo"),r.getInt("numero_da_movimentacao"),r.getDouble("valor"),r.getDate("data").toLocalDate(),r.getTime("hora").toLocalTime(), r.getBoolean("recebeu"), r.getInt("idobjetivo")));
                }
                    
            }
            return retorno;
            
        }catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ocorreu um erro, tente novamente mais tarde", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        } 
    }
    
    public ArrayList pegarMovimentacoesDeObjetivos(Usuario u){
        ArrayList<Movimentacoes> retorno =new ArrayList<Movimentacoes>();
        Conectar conexao = new Conectar();
        
        try{
            conexao.checarConexao();
            String sql = "SELECT * FROM movimentacoes WHERE cpf= '"+u.getCpf()+"' ORDER BY numero_da_movimentacao DESC";
            //String sql = "SELECT * FROM movimentacoes WHERE cpf= '"+u.getCpf()+"'";
            PreparedStatement ps = conexao.c.prepareStatement(sql); 
            ResultSet r= ps.executeQuery();
            while(r.next()){
                if(r.getInt("idobjetivo")>0){
                    retorno.add(new Movimentacoes(r.getString("cpf"),r.getString("motivo"),r.getInt("numero_da_movimentacao"),r.getDouble("valor"),r.getDate("data").toLocalDate(),r.getTime("hora").toLocalTime(), r.getBoolean("recebeu"), r.getInt("idobjetivo")));
                }
            }
            return retorno;
            
        }catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ocorreu um erro, tente novamente mais tarde", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        } 
    }
    
    public boolean inserirNoBD(Movimentacoes m){

        Conectar conexao = new Conectar();
        try{
            conexao.checarConexao();
            if(m.getIdobjetivo()==0){
                String sql = "INSERT INTO movimentacoes (numero_da_movimentacao, cpf, valor, motivo, data, hora, recebeu, idobjetivo) VALUES (?, ?, ?, ?, ?, ?, ?, null);";                                       
                PreparedStatement ps =conexao.c.prepareStatement(sql);
                ps.setInt(1, m.getNumero_movimentacao());
                ps.setString(2, m.getCPF());
                ps.setDouble(3, m.getValor());
                ps.setString(4, m.getMotivo());
                ps.setDate(5, Date.valueOf(m.getData()));
                ps.setTime(6, Time.valueOf(m.getHora()));
                ps.setBoolean(7, m.isRecebeu());
                ps.execute();
                conexao.c.close();
            }
            else{
                String sql = "INSERT INTO movimentacoes (numero_da_movimentacao, cpf, valor, motivo, data, hora, recebeu, idobjetivo) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";                                       
                PreparedStatement ps =conexao.c.prepareStatement(sql);
                ps.setInt(1, m.getNumero_movimentacao());
                ps.setString(2, m.getCPF());
                ps.setDouble(3, m.getValor());
                ps.setString(4, m.getMotivo());
                ps.setDate(5, Date.valueOf(m.getData()));
                ps.setTime(6, Time.valueOf(m.getHora()));
                ps.setBoolean(7, m.isRecebeu());
                ps.setInt(8, m.getIdobjetivo());
                ps.execute();
                conexao.c.close();
            }

            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            conexao.fechaConexao();
            return false;
        }
    }
    
    public boolean  atualizarNoBD(Movimentacoes m){
        Conectar conexao = new Conectar();
        try{
            conexao.checarConexao();
            String sql = "UPDATE movimentacoes SET valor = ?, motivo= ?, data= ?, hora= ?, recebeu= ? WHERE cpf = ? AND numero_da_movimentacao = ?; ";
            PreparedStatement ps = conexao.c.prepareStatement(sql);
            ps.setDouble(1, m.getValor());
            ps.setString(2, m.getMotivo());
            ps.setDate(3, Date.valueOf(m.getData()));
            ps.setTime(4, Time.valueOf(m.getHora()));
            ps.setBoolean(5, m.isRecebeu());
            ps.setString(6, m.getCPF());
            ps.setInt(7, m.getNumero_movimentacao());
            ps.execute();
            conexao.fechaConexao();
            
            return true;
        }catch(Exception ex){
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            conexao.fechaConexao();
            return false;
        }
    }

    public boolean deletarNoBD(String cpf, int movimentacoes){
        Conectar conexao= new Conectar();
        
        try{
            conexao.checarConexao();
            Statement s =conexao.c.createStatement();
            String sql="DELETE FROM movimentacoes WHERE cpf='"+cpf+"' AND numero_da_movimentacao='"+movimentacoes+"' ;";
            s.execute(sql);
            conexao.c.close();
            JOptionPane.showMessageDialog(null, "Remoção feita com sucesso!");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            conexao.fechaConexao();
            return false;
        }
    }
    
    public boolean deletarMovimentacaoDeObjetivos(String cpf, int idObjetivo){
        Conectar conexao= new Conectar();
        
        try{
            conexao.checarConexao();
            Statement s =conexao.c.createStatement();
            String sql="DELETE FROM movimentacoes WHERE cpf='"+cpf+"' AND idobjetivo='"+idObjetivo+"' ;";
            s.execute(sql);
            conexao.c.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            conexao.fechaConexao();
            return false;
        }
    }

}