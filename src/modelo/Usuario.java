
package modelo;

/**
 *
 * @author Armando
 */


import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.JOptionPane;
import java.io.IOException;
import  java.io.BufferedWriter;

public class Usuario {
    private String username;
    private String password;
    private String email;
    private String Contacto;
    private String tipoDeUsuario;
    private String codigouser;

    public String getCodigouser() {
        return codigouser;
    }

    public void setCodigouser(String codigouser) {
        this.codigouser = codigouser;
    }

    public String getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(String tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return username;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContacto() {
        return Contacto;
    }

    public void setContacto(String Contacto) {
        this.Contacto = Contacto;
    }
    
    public boolean recordUsuario(String username,String password,String email, String contacto,String TipoUsuario ,Path caminho) throws IOException{
        this.setUsername(username);
        try (BufferedWriter user = Files.newBufferedWriter(caminho, StandardCharsets.UTF_8)) {
            user.write("Nome: "+this.getUsername().toUpperCase());user.newLine();
            user.write("Password: "+this.getPassword().toUpperCase());user.newLine();
            user.write("E-mail: "+this.getEmail());user.newLine();
            user.write("Contacto: "+this.getContacto());user.newLine();
            user.write("Tipo de Usuário: "+this.getTipoDeUsuario());user.newLine();
            user.write("Codigo do Usuário: "+this.getCodigouser().toUpperCase());user.newLine();
            user.flush();
            return true;
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage()+ "\nErro ao gravar o ficheiro","ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }  
   
   
             
}
   
    
