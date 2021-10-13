/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus
 */
public class Conectar {

    public Connection c;

    public Connection getConexao(){
        try {
            String url="jdbc:postgresql://200.18.128.54/aula"; //SERVIDOR DO IF
            //String url="jdbc:postgresql://108.166.210.245/aula";   //servidor do janio onde ta o BD de teste pra quando o servidor do IF cair
            //String url="jdbc:postgresql://173.82.100.163/aula";  SERVIDOR DO JANIO USADO NA AUL
            String usuario="aula";
            String senha="aula";
            this.c = DriverManager.getConnection(url, usuario, senha);
            this.c.setSchema("matheus_peixoto");
            return c;
        } catch (SQLException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    private void abrirConexao() {
        this.getConexao();
    }

    public void fechaConexao() {
        try {
            if (this.c != null && !this.c.isClosed()) {
                this.c.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void checarConexao() {
        try {
            if (this.c == null || this.c.isClosed()) {
                this.abrirConexao();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
