/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Email;

import Objetos.Usuario;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author Matheus
 */
public class EnviarEmail {
    //Código base: https://www.youtube.com/watch?v=xBZqr4Gdnck&t=433s&ab_channel=CarlosHenriqueJava
    private String meuEmail = "trabalhoBDePROG@gmail.com";
    private String minhaSenha = "tr@balhoBD3PROG";
    private SimpleEmail email = new SimpleEmail();
    
    public void configurarEmail(){
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator(meuEmail, minhaSenha));
        email.setSSLOnConnect(true);
    }
    
    public void enviarSenha(Usuario u){
        configurarEmail();
        try{
            email.setFrom(meuEmail);
            email.setSubject("Sua senha");
            email.setMsg("Olá "+u.getNome()+" "+u.getSobrenome()+"\nAqui está a sua senha: "+u.getSenha()+"\nAltere-a assim que for possível! :)");
            email.addTo(u.getEmail());
            email.send();
            System.out.println("Email enviado com sucesso!");
        }catch(Exception e){
            System.out.println("Erro");
        }
    }

    public boolean verificarEmail(Usuario u, int codigo){
        configurarEmail();
        try{
            email.setFrom(meuEmail);
            email.setSubject("Verificar email");
            email.setMsg("Olá "+u.getNome()+" "+u.getSobrenome()+"\n\nAqui está o seu código de verificação de email: "+codigo);
            email.addTo(u.getEmail());
            email.send();
            //System.out.println("Email enviado com sucesso!");
            return true;
        }catch(Exception e){
            //System.out.println("Erro ao enviar verificação " + e);
            return false;
        }
    }
            
}
