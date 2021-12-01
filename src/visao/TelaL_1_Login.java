
package visao;


import Controle.FluxoUsuario;
import Controle.Fluxo_AgendaDat;
import Controle.Fluxo_PacienteDat;
import javax.swing.*;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URI;
import java.nio.file.*;
import java.util.*;

/**
 *
 * @author armando
 */
public abstract class TelaL_1_Login extends JFrame implements ActionListener{
    
    JLabel FundoLogin = new JLabel();
    JLabel FundoLogo=new JLabel();
    JLabel NomeSistema = new JLabel("SISTEMA DE GESTÃO DO PACIENTE NO PLANEAMENTO FAMILIAR");
    JLabel usericon= new JLabel(new ImageIcon(getClass().getResource("/Imagens/login.png")));
    JLabel UserName = new JLabel("Nome do Usuário");
    JLabel Senha = new JLabel ("Senha");
    JButton Acessar = new JButton(new ImageIcon(getClass().getResource("/Imagens/confirma.png")));
    JButton Sair = new JButton(new ImageIcon(getClass().getResource("/Imagens/shutdown.png")));
    JButton info= new JButton("Click  aqui para  Informações sobre Planeamento Familiar");
    
    JCheckBox show = new JCheckBox("Mostrar",new ImageIcon(getClass().getResource("/Imagens/show.png")));
    
    JTextField nomeUsuario = new JTextField();
    JPasswordField password = new JPasswordField();
    
    JMenuBar barra = new JMenuBar();
    JMenu menu=new JMenu("Configurações");
    JMenuItem gerir= new JMenuItem("Gestão de usuários ");
   
    Font fonte= new Font("Cambria",Font.BOLD,15);
   
   public TelaL_1_Login(){
        
    setTitle("SIS-GESP01-Tela Login");
    setLayout(null);
    setSize(1600,1200);
    setVisible(true);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    
    setJMenuBar(barra);
    barra.add(menu);
    menu.add(gerir);
    
    add(usericon);
    usericon.setBounds(600, 150, 128, 128);
    
    NomeSistema.setFont(new java.awt.Font("Cambria", 1, 35)); 
    add(NomeSistema);
    NomeSistema.setBounds(235, 50, 1500, 60);
   

    UserName.setFont(fonte);
    add(UserName);
    UserName.setBounds(450, 300, 200, 30);
    add(nomeUsuario);
    nomeUsuario.setBounds(580, 300, 250, 30);

    Senha.setFont(fonte); 
    add(Senha);
    Senha.setBounds(450, 340, 200, 30);
    add(password);
    password.setBounds(580, 340, 250, 30);
    
    add(show);
    show.setBounds(850,340,100,30);
    show.setSelected(false);
    show.setFont(fonte);
    show.setSelected(false);
    
    add(info);
    info.setFont(fonte);
    info.setBounds(0,666,1600,50);
    
    add(Acessar);
    Acessar.setFont(fonte); 
    Acessar.setBounds(600, 410, 60, 48);
    Acessar.setContentAreaFilled(false);
    
    add(Sair);
    Sair.setFont(fonte); 
    Sair.setBounds(710, 410, 60, 48);
    Sair.setContentAreaFilled(false);

    FundoLogo.setIcon(new ImageIcon(getClass().getResource("/Imagens/logo.png")));
    FundoLogo.setFocusable(false);
    FundoLogo.setPreferredSize(new java.awt.Dimension(225, 225));
    add(FundoLogo);
    FundoLogo.setBounds(2, 2, 225, 225);

    FundoLogin.setIcon(new ImageIcon(getClass().getResource("/Imagens/image fundo.png")));
    FundoLogin.setFocusable(false);
    FundoLogin.setPreferredSize(new java.awt.Dimension(1600, 1200));
    getContentPane().add(FundoLogin);
    FundoLogin.setBounds(0, 0, 1600, 666);
   
   Acessar.addActionListener(this);
   info.addActionListener(this);
   Sair.addActionListener(this);
   gerir.addActionListener(this);
   
    show.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ea){
                if(show.isSelected()){
                    password.setEchoChar((char)0);
                }else{
                    password.setEchoChar((char)-1);
                }
                
            }
    });   
}
public void actionPerformed(ActionEvent ae) {
            if(ae.getSource()==Acessar){
            ArrayList<String> usuarios = new ArrayList<>();
            FluxoUsuario user = new FluxoUsuario();
            String nome=nomeUsuario.getText();
            String senha=password.getText();
            if((!UserName.getText().isEmpty())&&(!password.getText().isEmpty())){
                if(Files.exists(Paths.get("C:/GESP01/Dados_Usuario"))==true){
                    try {
                        if(user.lerUsuarios(usuarios, Paths.get("C:/GESP01/Dados_Usuario/"+nome.toUpperCase()+"/dados.txt")) == true)
                            for(int i = 0; i < usuarios.size(); i++){
                                Path caminho= Paths.get("C:/GESP01/Dados_Usuario/"+nome.toUpperCase()+"/dados.txt");
                                try{
                                    byte[]texto= Files.readAllBytes(caminho);
                                    String dados= new String(texto);
                                    if(dados.contains(senha.toUpperCase())&& dados.contains("Funcionario")){
                                        new Tela_1_Funcionario() {
                                            @Override
                                            public void actionPerformed(ActionEvent ae) {
                                            }
                                        };
                                        dispose();
                                       // break;
                                    }else{
                                        //JOptionPane.showMessageDialog(null, "SENHA INCORRECTA", "Erro!!", JOptionPane.ERROR_MESSAGE);
                                        password.setText("");
                                       // break;
                                    }
                                    if(dados.contains(senha.toUpperCase())&& dados.contains("Atendimento")){
                                         new Tela_1_Atendimento() {
                                             @Override
                                             public void actionPerformed(ActionEvent ae) {
                                                 throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                                             }
                                         };
                                         dispose();
                                         break;
                                    }else{
                                        //JOptionPane.showMessageDialog(null, "SENHA INCORRECTA", "Erro!!", JOptionPane.ERROR_MESSAGE);
                                        password.setText("");
                                        //break;
                                    }
                                    if(dados.contains(senha.toUpperCase())&& dados.contains("Administrador")){
                                         new Tela_1_Administrador() {
                                             @Override
                                             public void actionPerformed(ActionEvent ae) {
                                                 throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                                             }
                                         };
                                         dispose();
                                         break;
                                    }else{
                                       // JOptionPane.showMessageDialog(null, "SENHA INCORRECTA", "Erro!!", JOptionPane.ERROR_MESSAGE);
                                        password.setText("");
                                       // break;
                                    }
                                    
                                }catch(IOException erro){
                                    JOptionPane.showMessageDialog(null,"FALHA NA AUTENTICAÇÃO \nC","Informações ", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                    }catch (IOException ex) {
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null,"FALHA NA AUTENTICAÇÃO \nCampos  não  Preenchidos","Erro!!", JOptionPane.ERROR_MESSAGE);
            }
            }
          if(ae.getSource()==info){
              try {
                 URI link= new URI("https://pt.wikipedia.org/wiki/Planejamento_familiar");
                  Desktop.getDesktop().browse(link);
              } catch (Exception e) {
              }
          } 
          if(ae.getSource()==Sair){
            System.exit(0);
          }
          if(ae.getSource()==gerir){
            ArrayList<String> usuarios = new ArrayList<>();
            FluxoUsuario user = new FluxoUsuario();
            String nome=JOptionPane.showInputDialog("   Nome do Admininistrador");
            String senha=JOptionPane.showInputDialog("   Senha do Administrador");
            if((!nome.isEmpty())&&(!senha.isEmpty())){
                if((nome.equalsIgnoreCase("admin"))&&(senha.equalsIgnoreCase("admin"))){
                    new Tela_1_Administrador() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                        }
                        
                    };
                    dispose();
                } else{
                if(Files.exists(Paths.get("C:GESP01/Dados_Usuario"))==true){
                    try {
                        if(user.lerUsuarios(usuarios, Paths.get("C:/GESP01/Dados_Usuario/"+nome.toUpperCase()+"/dados.txt")) == true)
                            for(int i = 0; i < usuarios.size(); i++){
                                Path caminho= Paths.get("C:/GESP01/Dados_Usuario/"+nome.toUpperCase()+"/dados.txt");
                                try{
                                    byte[]texto= Files.readAllBytes(caminho);
                                    String dados= new String(texto);
                                    if((dados.contains(senha.toUpperCase())&& dados.contains("Administrador")) ){
                                       new Tela_1_Administrador() {
                                           @Override
                                           public void actionPerformed(ActionEvent ae) {
                                           }
                                       };
                                        dispose();
                                        break;
                                    }                                   
                                }catch(IOException erro){
                                    JOptionPane.showMessageDialog(null,"FALHA NA AUTENTICAÇÃO \nC","Informações ", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                    }catch (IOException ex) {
                    }
                }
                }
            }else{
                JOptionPane.showMessageDialog(null,"FALHA NA AUTENTICAÇÃO \nCampos  não  Preenchidos","Erro!!", JOptionPane.ERROR_MESSAGE);
            }
             
          }
        
    }           
    public static void main(String[] args) { 
        Fluxo_PacienteDat ficheiro= new Fluxo_PacienteDat();
        Fluxo_AgendaDat ficheiro2=new Fluxo_AgendaDat();
        ficheiro.CaminhoPrincipal();//paciente
        ficheiro2.CaminhoPrincipal();//Agenda
        File file0=new File("C:/GESP01");
        File file1=new File("C:/GESP01/Dados_Usuario");
        file0.mkdir();
        file1.mkdir();
        new TelaL_1_Login(){}; 
    }

    
}
