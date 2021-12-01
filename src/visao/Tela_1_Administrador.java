
package visao;

/**
 *
 * @author Lelifork
 */

import Controle.FluxoUsuario;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public abstract class Tela_1_Administrador extends JFrame implements ActionListener{
			
    JLabel FundoLogin = new JLabel();  
    JLabel iconadmin = new JLabel();    
    JButton Adicionar = new JButton("Adicionar Usuários",new ImageIcon(getClass().getResource("/Imagens/adicionarUser.png")));
    JButton listar = new JButton("Listar Usuários",new ImageIcon(getClass().getResource("/Imagens/listarUser.png")));
    JButton pesquisar =new JButton("Pesquisar Usuários",new ImageIcon(getClass().getResource("/Imagens/pesquisarUser.png")));
    JButton Remover = new JButton("Eliminar Usuários",new ImageIcon(getClass().getResource("/Imagens/deleteUser.png")));
    
    JMenuBar barra = new JMenuBar();
    JMenu menu=new JMenu("Opções");
    JMenuItem Sair= new JMenuItem("Terminar Sessão ");
    
    Font fonte= new Font("Cambria",Font.PLAIN,15);
   
    public Tela_1_Administrador(){
	
        setTitle("GESP01-PAINEL-Administrador");
        setLayout(null);
        setSize(1000,500);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        setJMenuBar(barra);
        barra.add(menu);
        menu.add(Sair);

       
        Adicionar.setFont(fonte);      
        getContentPane().add(Adicionar);
       	Adicionar.setBounds(180, 50, 250, 70);
        Adicionar.setContentAreaFilled(false);
   
       	listar.setFont(fonte);
        getContentPane().add(listar);
       	listar.setBounds(180, 150, 250, 70);
        listar.setContentAreaFilled(false);
       	
       	pesquisar.setFont(fonte);   
        getContentPane().add(pesquisar);
       	pesquisar.setBounds(180, 250, 250, 70);
        pesquisar.setContentAreaFilled(false);
       
       	
       	Remover.setFont(fonte); 
        getContentPane().add(Remover);
       	Remover.setBounds(180, 350, 250, 70);
        Remover.setContentAreaFilled(false);
     
                
        Adicionar.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            new Tela_1_Registo_User() {
                @Override
                public void actionPerformed(ActionEvent ae) { 
                }
            };
            dispose();
         }
        });
        
        listar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                FluxoUsuario fluxo= new FluxoUsuario();
                try {
                fluxo.VisualizarUsuarios();
                   }
                catch (Exception ex) {
                }	                
            }
        });
        pesquisar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                FluxoUsuario fluxo= new FluxoUsuario();
                try {
                    fluxo.PesquisarUsuarios();
                }
                catch (Exception ex) {
                }   
            }
        });
        
        Remover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                FluxoUsuario fluxo= new FluxoUsuario();
               try {
                fluxo.removerUsuarios();
                }
                catch (Exception ex) {
                }
            }
        });
       
        Sair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new TelaL_1_Login() {
           };
                dispose();
            }
        });
           
        iconadmin.setIcon(new ImageIcon(getClass().getResource("/Imagens/administrador.png")));
        getContentPane().add(iconadmin);
        iconadmin.setBounds(450, 80, 250, 240);       
               
        
        FundoLogin.setIcon(new ImageIcon(getClass().getResource("/Imagens/image fundo.png")));
       	FundoLogin.setFocusable(false);
        FundoLogin.setPreferredSize(new java.awt.Dimension(1600, 1000));
        getContentPane().add(FundoLogin);
        FundoLogin.setBounds(0, 0, 1000, 500);
    } 
    
}
