/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoBD;

//import cadastro.modelo.Pessoa;
import Objetos.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Matheus
 */
public class DAOUsuario {
    //private Connection c;


    
    public boolean cadastrarUsuario(Usuario u){
        Conectar conexao = new Conectar();
        try {
            conexao.checarConexao();
            String sql="INSERT INTO usuario ( nome, sobrenome, cpf, email, senha, saldo) VALUES ( '"+u.getNome()+"', '"+u.getSobrenome()+"', '"+u.getCpf()+"', '"+u.getEmail()+"', '"+u.getSenha()+"','"+u.getSaldo()+"' )";
            Statement s =conexao.c.createStatement();
            s.execute(sql);
            conexao.c.close();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            conexao.fechaConexao();
        }
        return false;
        
    }
    public Usuario verificarUsuariosCadastrados(Usuario u){
        Conectar conexao = new Conectar();
        try {
            String sql = "SELECT * FROM usuario WHERE cpf= '"+u.getCpf()+"' OR email= '"+u.getEmail()+"';";
            conexao.checarConexao();
            PreparedStatement ps = conexao.c.prepareStatement(sql);
            ResultSet r = ps.executeQuery();
            Usuario u1 = null;
            while(r.next()){
                if(u.getCpf().equals(r.getString("cpf") ) || u.getEmail().equals(r.getString("email") ) ){
                    //System.out.println("Entrou");
                    u1 = new Usuario(r.getString("nome"),
                                     r.getString("sobrenome"),
                                     r.getString("cpf"),
                                     r.getString("email"),
                                     r.getString("senha"),
                                     r.getDouble("saldo"));
                }
            }

            conexao.fechaConexao();
            return u1;

        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ocorreu um erro, tente novamente mais tarde", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    public boolean atualizarSaldo(Usuario u){
        Conectar conexao = new Conectar();
        
        try {

            conexao.checarConexao();
            String sql="UPDATE usuario SET saldo = '"+u.getSaldo()+"' WHERE cpf= '"+u.getCpf()+"';";
            Statement s =conexao.c.createStatement();
            s.execute(sql);
            conexao.c.close();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            conexao.fechaConexao();
            return false;
        }
    }
    public void atualizarUsuario(Usuario u){
        Conectar conexao = new Conectar();
        try{
            conexao.checarConexao();
            String sql = "UPDATE usuario SET nome = ?, sobrenome = ?, email= ?, senha= ?, saldo=? WHERE cpf=?;";
            PreparedStatement ps = conexao.c.prepareStatement(sql);
            ps.setString(1, u.getNome());
            ps.setString(2, u.getSobrenome());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getSenha());
            ps.setDouble(5, u.getSaldo());
            ps.setString(6, u.getCpf());
            ps.execute();
            conexao.fechaConexao();
            JOptionPane.showMessageDialog(null, "Alteração de dados realizada com sucesso!");
        }catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            conexao.fechaConexao();
        }
    }
    
    public void apagarConta(Usuario u){
        Conectar conexao= new Conectar();
        
        try{
            conexao.checarConexao();
            Statement s =conexao.c.createStatement();
            String sql="DELETE FROM movimentacoes WHERE cpf='"+u.getCpf()+"' ;";
            s.execute(sql);
            String sq2="DELETE FROM objetivos WHERE cpf='"+u.getCpf()+"' ;";
            s.execute(sq2);
            String sql3="DELETE FROM usuario WHERE cpf='"+u.getCpf()+"' ;";
            s.execute(sql3);
            conexao.c.close();
            JOptionPane.showMessageDialog(null, "Remoção feita com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            conexao.fechaConexao();
        }
    }
}
