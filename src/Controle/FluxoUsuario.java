package Controle;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author armando
 */
public class FluxoUsuario {

    public FluxoUsuario() {

    }

    public void VisualizarUsuarios() throws IOException {
        File diretorios = new File("C:/GESP01/Dados_Usuario");
        if ((diretorios.listFiles().length) == 0) {
            JOptionPane.showMessageDialog(null, "Sem usuarios Registados");
        } else {
            JOptionPane.showMessageDialog(null, (diretorios.list()), "      LISTA NOMINAL DOS USUARIOS", JOptionPane.INFORMATION_MESSAGE);
 
        }
    }

    public boolean lerUsuarios(ArrayList<String> usuarios, Path caminho) throws IOException {
        try (BufferedReader readUser = Files.newBufferedReader(caminho, StandardCharsets.UTF_8)) {
            String lineUser;
            while ((lineUser = readUser.readLine()) != null) {
                usuarios.add(lineUser);
            }
            return true;
        } catch (IOException e2) {
            JOptionPane.showMessageDialog(null, "USUARIO  NÃO  REGISTADO", "Erro!!", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public void removerUsuarios() throws IOException {
        ArrayList<String> usuarios = new ArrayList<>();
        FluxoUsuario user = new FluxoUsuario();
        String codigo = JOptionPane.showInputDialog("Codigo do Usuario");
        String senha = JOptionPane.showInputDialog("Senha do Usuario");
        if (Files.exists(Paths.get("C:\\GESP01")) == true) {
            try {
                if (user.lerUsuarios(usuarios, Paths.get("C:/GESP01/Dados_Usuario/" + codigo.toUpperCase() + "/dados.txt")) == true) {
                    for (int i = 0; i < usuarios.size(); i++) {
                        Path caminho = Paths.get("C:/GESP01/Dados_Usuario/" + codigo.toUpperCase() + "/dados.txt");
                        byte[] texto = Files.readAllBytes(caminho);
                        String dados = new String(texto);
                        if (dados.contains(senha.toUpperCase())) {
                            Files.delete(caminho);
                            File file = new File("C:/GESP01/Dados_Usuario/" + codigo.toUpperCase());
                            file.delete();
                            JOptionPane.showMessageDialog(null, codigo.toUpperCase() + "\nELIMINADO DA LISTA DOS USUARIOS");
                        }
                    }
                }
            } catch (IOException ex) {
            }
        }

    }

    public void PesquisarUsuarios() throws IOException {
        ArrayList<String> usuarios = new ArrayList<>();
        FluxoUsuario user = new FluxoUsuario();
        String codigo = JOptionPane.showInputDialog("Codigo do usuario");
        if (Files.exists(Paths.get("C:/GESP01/Dados_Usuario")) == true) {
            try {
                if (user.lerUsuarios(usuarios, Paths.get("C:/GESP01/Dados_Usuario/" + codigo + "/dados.txt")) == true) {
                    for (int i = 0; i < usuarios.size(); i++) {
                        Path caminho = Paths.get("C:/GESP01/Dados_Usuario/" + codigo + "/dados.txt");
                        byte[] texto = Files.readAllBytes(caminho);
                        String dados = new String(texto);
                        if (dados.contains(codigo.toUpperCase())) {
                            JOptionPane.showMessageDialog(null, "\n"+dados, "     DADOS DO USUARIO: "+codigo.toUpperCase(), JOptionPane.INFORMATION_MESSAGE);break;
                        } else {
                            JOptionPane.showMessageDialog(null, "USUARIO DESCONHECIDO", "Erro!", JOptionPane.ERROR_MESSAGE);break;
                        }
                    }
                }
            } catch (IOException ex) {
            }
        }
    }
}
