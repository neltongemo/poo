
package visao;
import javax.swing.*;
import modelo.Usuario;
import java.io.IOException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.*;
import java.util.*;

/**
 *
 * @author Lelifork
 */
public abstract class Tela_1_Registo_User extends JFrame implements ActionListener{
    JLabel FundoLogin = new JLabel();  
    JLabel NomeSistema = new JLabel("Formulário de Registo do Usuário ");
    JLabel username = new JLabel("Nome do Usuário :");    
    JLabel password = new JLabel("Senha:");
    JLabel email = new JLabel("E_mail:");
    JLabel contacto = new JLabel("Contacto"); 
    JLabel tipoUser = new JLabel("Tipo de Usuario"); 
    JLabel Codigouser = new JLabel("Codigo do Usuário "); 
    
    
    JLabel iconusuario = new JLabel();
    
    JTextField JTFusername = new JTextField();
    JTextField JTFpass = new JTextField();
    JTextField JTFemail = new JTextField();
    JTextField JTFcontacto = new JTextField();
    JTextField JTFCodigouser = new JTextField(); 
    
    JRadioButton Admin=new JRadioButton("Administrador");
    JRadioButton Atendimento=new JRadioButton("Atendimento");
    JRadioButton Aceitacao=new JRadioButton("Funcionario");
    ButtonGroup grupouser= new ButtonGroup();
    
    JMenuBar barra = new JMenuBar();
    JMenu menu=new JMenu("Opções");
    JMenuItem Sair= new JMenuItem("Terminar Sessão ");
        
    JButton Salvar = new JButton("Salvar",new ImageIcon(getClass().getResource("/Imagens/save.png")));
    
    
    Font fonte= new Font("Cambria",Font.PLAIN,15);
    
    public Tela_1_Registo_User(){
    setTitle("GESP01-PAINEL-Registo-Usuario");
    setLayout(null);
    setSize(1000,500);
    setVisible(true);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

    setJMenuBar(barra);
    barra.add(menu);
    menu.add(Sair);

    NomeSistema.setFont(fonte); 
    getContentPane().add(NomeSistema);
    NomeSistema.setBounds(20, 5, 760, 60);


    username.setFont(fonte); 
    getContentPane().add(username);
    username.setBounds(50, 100, 330, 30);
    password.setFont(fonte); 
    getContentPane().add(password);
    password.setBounds(50, 150, 330, 30);

    getContentPane().add(JTFusername);
    JTFusername.setBounds(180, 100, 250, 30);
    getContentPane().add(JTFpass);
    JTFpass.setBounds(180, 150, 250, 30);

    email.setFont(fonte); 
    getContentPane().add(email);
    email.setBounds(50, 200, 330, 30);
    contacto.setFont(fonte); 
    getContentPane().add(contacto);
    contacto.setBounds(50, 250, 330, 30);
    
    Codigouser.setFont(fonte); 
    getContentPane().add(Codigouser);
    Codigouser.setBounds(50, 300, 330, 30);
    JTFCodigouser.setFont(fonte); 
    getContentPane().add(JTFCodigouser);
    JTFCodigouser.setBounds(180, 300, 250, 30);
     final int numero= (int)(Math.random()*1);
    JTFCodigouser.setText(JTFusername.getText().concat(String.valueOf(numero)));
    
    getContentPane().add(JTFemail);
    JTFemail.setBounds(180, 200, 250, 30);
    getContentPane().add(JTFcontacto);
    JTFcontacto.setBounds(180, 250, 250, 30);

    tipoUser.setFont(fonte); 
    getContentPane().add(tipoUser);
    getContentPane().add(Admin);
    getContentPane().add(Atendimento);
    getContentPane().add(Aceitacao);
    grupouser.add(Admin);
    grupouser.add(Atendimento);
    grupouser.add(Aceitacao);
    tipoUser.setBounds(700, 100, 120, 30);
    Admin.setBounds(700, 130, 120, 30);
    Atendimento.setBounds(700, 150, 120, 30);
    Aceitacao.setBounds(700, 170, 120, 30);

    getContentPane().add(Salvar);
    Salvar.setBounds(750, 350, 150, 48);
    Salvar.setContentAreaFilled(false);

    iconusuario.setIcon(new ImageIcon(getClass().getResource("/Imagens/adicionarUser.png")));
    getContentPane().add(iconusuario);
    iconusuario.setBounds(450, 80, 250, 240);

    FundoLogin.setIcon(new ImageIcon(getClass().getResource("/Imagens/image fundo.png")));
    FundoLogin.setFocusable(false);
    FundoLogin.setPreferredSize(new Dimension(1600, 1000));
    getContentPane().add(FundoLogin);
    FundoLogin.setBounds(0, 0, 1000, 500);

    Salvar.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
    ArrayList<String> Usuarios= new ArrayList<>();
    Usuario user=new Usuario();
    if ((JTFusername.getText().isEmpty()) ||(JTFpass.getText().isEmpty())||(JTFemail.getText().isEmpty())||(JTFcontacto.getText().isEmpty())||"null".equals(String.valueOf(grupouser.getSelection())) ) {
       JOptionPane.showMessageDialog(null, "\n         FALHA NO REGISTO\nEXISTEM CAMPOS NÃO PREENCHIDOS", "informação", JOptionPane.ERROR_MESSAGE);     
         } else {

        user.setUsername(JTFusername.getText());
        user.setPassword(JTFpass.getText());
        user.setEmail(JTFemail.getText().toLowerCase());
        user.setContacto(JTFcontacto.getText());
        
        user.setCodigouser(JTFusername.getText().concat(String.valueOf(numero)));
        if(Admin.isSelected()){
        user.setTipoDeUsuario("Administrador");	
        }
        if(Atendimento.isSelected()){
            user.setTipoDeUsuario("Atendimento");
        }
        if(Aceitacao.isSelected()){
            user.setTipoDeUsuario("Funcionario");
        }
        Path path = Paths.get("C:/GESP01/Dados_Usuario/" + user.getCodigouser().toUpperCase() + "/dados.txt");
        try {
            Files.createDirectory(path.getParent());

            user.recordUsuario(JTFusername.getText(),JTFpass.getText(),JTFemail.getText(),JTFcontacto.getText(),(String.valueOf(grupouser.getSelection())), path);
            JOptionPane.showMessageDialog(null, "Nome do Usuário : "+user.getCodigouser()+"\nSenha: "+user.getPassword(), "Dados de Acesso", JOptionPane.INFORMATION_MESSAGE);
            limparCampos(); 
        } catch (IOException ex) {
        }
    }
    } 
     });
    Sair.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
        Tela_1_Administrador add = new Tela_1_Administrador() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            }
        };
        dispose();
    }
     });  
    } 
    
    public void limparCampos(){
    JTFusername.setText("");
    JTFpass.setText("");
    JTFemail.setText("");
    JTFcontacto.setText("");
    JTFCodigouser.setText("");
    grupouser.clearSelection();
    } 
}
