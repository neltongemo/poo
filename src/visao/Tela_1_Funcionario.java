
package visao;

/**
 *
 * @author Lelifork
 */


import Controle.Fluxo_PacienteDat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;

public abstract class Tela_1_Funcionario extends JFrame implements ActionListener{
			
    JLabel FundoLogin = new JLabel();  
    JLabel NomeSistema = new JLabel("SISTEMA DE GESTÃO DO PACIENTE NO PLANEAMENTO FAMILIAR");
    JButton info= new JButton("Click  aqui para Informações  sobre Planeamento Familiar");
   
 
    JButton Adicionar = new JButton(new ImageIcon(getClass().getResource("/Imagens/adicionarUser.png")));
    JButton Agenda = new JButton(new ImageIcon(getClass().getResource("/Imagens/agenda.png")));
    JButton pesquisar =new JButton(new ImageIcon(getClass().getResource("/Imagens/pesquisarUser.png")));
    JButton cartao = new JButton(new ImageIcon(getClass().getResource("/Imagens/Ficha.png")));
    
    JMenuBar barra = new JMenuBar();
    JMenu menu=new JMenu("Opções");
    JMenuItem Relatorio= new JMenuItem("Gerar Relatorio");
    JMenuItem Sair= new JMenuItem("Terminar Sessão ");
    
    JLabel FundoLogo= new JLabel();
    
    JLabel JLAdicionar = new JLabel("REGISTAR");
    JLabel JLagenda = new JLabel("AGENDAR CONSULTA");
    JLabel JLpesquisar =new JLabel("PESQUISAR");
    JLabel JLficha = new JLabel("FICHA DE PF");
    
    
    Font fonte= new Font("Cambria",Font.BOLD,15);
    Font fonte1= new Font("Cambria",Font.BOLD,35);
   
    public Tela_1_Funcionario(){
	
        setTitle("GESP01-PAINEL-ACEITAÇÃO");
        setLayout(null);
        setSize(1600,1000);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        setJMenuBar(barra);
        barra.add(menu);
        menu.add(Relatorio);
        menu.add(Sair);
        
        NomeSistema.setFont(fonte1); 
        add(NomeSistema);
        NomeSistema.setBounds(235, 50, 1500, 60);
        
       
            
        add(Adicionar);
        Adicionar.setBounds(300, 295, 100, 100);
        Adicionar.setContentAreaFilled(false);
  
        getContentPane().add(pesquisar);
       	pesquisar.setBounds(500, 295, 100, 100);
        pesquisar.setContentAreaFilled(false);
        
        
        Agenda.setFont(fonte);   
        getContentPane().add(Agenda);
       	Agenda.setBounds(900, 295, 100, 100);
        Agenda.setForeground(Color.magenta);
        Agenda.setContentAreaFilled(false);
        

       	cartao.setFont(fonte); 
        getContentPane().add(cartao);
        cartao.setBounds(700, 295, 100, 100);
        cartao.setForeground(Color.RED);
        cartao.setContentAreaFilled(false);
       
        add(JLAdicionar);
        add(JLpesquisar);
        add(JLficha);
        add(JLagenda);
        JLAdicionar.setBounds(315, 360, 115, 115);
        JLAdicionar.setForeground(Color.black);
        JLAdicionar.setFont(fonte); 
        
        JLpesquisar.setBounds(515, 360, 115, 115);
        JLpesquisar.setForeground(Color.blue);
        JLpesquisar.setFont(fonte); 
        
        JLficha.setBounds(715, 360, 115, 115);
        JLficha.setForeground(Color.RED);
        JLficha.setFont(fonte); 
        
        JLagenda.setBounds(890, 360, 150, 115);
        JLagenda.setForeground(Color.DARK_GRAY);
        JLagenda.setFont(fonte); 
         
        Adicionar.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
           new Tela_1_Registo_PacienteDat(){
               
               public void actionPerformed(ActionEvent ae) {
               }
           };
            dispose();
         }
        });
        
        Agenda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               new Tela_1_Registo_Agenda() {
                   @Override
                   public void actionPerformed(ActionEvent ae) {
                       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                   }
               };
            }
        });
        pesquisar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                
                try {
                    new Tela_1_DadosPaciente() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }
                    };
                }
                catch (Exception ex) {
                }   
            }
        });
        
        cartao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Fluxo_PacienteDat fluxo= new Fluxo_PacienteDat();
               try {
                new FICHA_PF() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                };
                }
                catch (Exception ex) {
                }
            }
        });
        
        Relatorio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               Fluxo_PacienteDat fluxo= new Fluxo_PacienteDat();
               fluxo.estatistica();
            }
        });
        
         info.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
              try {
                  URI link= new URI("https://pt.wikipedia.org/wiki/Planejamento_familiar");
                  Desktop.getDesktop().browse(link);
                  
              } catch (Exception e) {
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
       
        add(info);
        info.setFont(fonte);
        info.setBounds(0,666,1600,80);
        info.setBackground(Color.LIGHT_GRAY);
        
        
         //------------------------------------logos
        
       
        
        FundoLogo.setIcon(new ImageIcon(getClass().getResource("/Imagens/metodo.jpg")));
        FundoLogo.setPreferredSize(new java.awt.Dimension(225, 225));
        add(FundoLogo);
        FundoLogo.setBounds(2, 2, 200, 200);
        
        
        //------------------------------------
        
        FundoLogin.setIcon(new ImageIcon(getClass().getResource("/Imagens/image fundo.png")));
        FundoLogin.setFocusable(false);
        FundoLogin.setPreferredSize(new java.awt.Dimension(1600, 1200));
        getContentPane().add(FundoLogin);
        FundoLogin.setBounds(0, 0, 1600, 666);
    
    }
   
}
