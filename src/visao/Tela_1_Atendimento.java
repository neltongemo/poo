
package visao;

/**
 *
 * @author Armando
 */

import Controle.Fluxo_AgendaDat;
import Controle.Fluxo_PacienteDat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.AgendaDat;

public abstract class Tela_1_Atendimento extends JFrame implements ActionListener{
			
    JLabel FundoLogin = new JLabel();  
    JLabel NomeSistema = new JLabel("SISTEMA DE GESTÃO DO PACIENTE NO PLANEAMENTO FAMILIAR");
    JButton info= new JButton("Click  aqui para Informações  sobre Planeamento Familiar");
   
 
    JButton VerAgenda = new JButton(new ImageIcon(getClass().getResource("/Imagens/agenda.png")));
    JButton Consulta1 = new JButton(new ImageIcon(getClass().getResource("/Imagens/consulta1.png")));
    JButton consultaSeguinte =new JButton(new ImageIcon(getClass().getResource("/Imagens/consulta2.png")));
    JLabel JLAgenda = new JLabel("VER AGENDA");
    JLabel JLconsulta1 = new JLabel("PRIMEIRA CONSULTA");
    JLabel JLconsulta2 =new JLabel("CONSULTAS SEGUINTES");
    
    
    JMenuBar barra = new JMenuBar();
    JMenu menu=new JMenu("Opções");
    JMenuItem Sair= new JMenuItem("Terminar Sessão ");
    JMenuItem Relatorio= new JMenuItem("Gerar Relatorio ");
    
    Font fonte= new Font("Cambria",Font.BOLD,15);
    Font fonte1= new Font("Cambria",Font.BOLD,35);
    
     //----------------------------------------------------------
    Date data = new Date();
    SimpleDateFormat formatar =new SimpleDateFormat("dd/MM/yyyy");
    String dataformatada=formatar.format(data);
    int numeroNID = 2020;
    //----------------------------------------------------------
   
    public Tela_1_Atendimento(){
	
        setTitle("GESP01-PAINEL-Atendimento");
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
    
        add(VerAgenda);
        add(JLAgenda);
        VerAgenda.setBounds(400, 295, 100, 100);
        JLAgenda.setBounds(400, 355, 100, 100);
        VerAgenda.setContentAreaFilled(false);
        JLAgenda.setFont(fonte);
        
        add(Consulta1);
        add(JLconsulta1);
       	Consulta1.setBounds(610, 295, 100, 100);
        JLconsulta1.setBounds(580, 355, 150, 100);
        Consulta1.setContentAreaFilled(false);
        JLconsulta1.setFont(fonte);
        
        add(consultaSeguinte);
        add(JLconsulta2);
       	consultaSeguinte.setBounds(810, 295, 100, 100);
        JLconsulta2.setBounds(780, 355, 200, 100);
        consultaSeguinte.setContentAreaFilled(false);
       JLconsulta2.setFont(fonte);
        
        Consulta1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
           new Tela_1_Consulta1() {
               @Override
               public void actionPerformed(ActionEvent ae) {
                   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
               }
           };
            dispose();
         }
        });
        
       
        consultaSeguinte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                
                try {
                    new Tela_1_ConsultaSeguinte() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }
                    };
                }
                catch (Exception ex) {
                }
                dispose();
            }
        });
       
       
        VerAgenda.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent evt) {             
            boolean achou=false;
            try {
            FileInputStream readData = new FileInputStream("C:/GESP01/BDGESP01_AGENDA.dat");
            ObjectInputStream os = new ObjectInputStream(readData);
            Fluxo_AgendaDat ficheiro=new Fluxo_AgendaDat();
            AgendaDat p=new AgendaDat();
            ArrayList<AgendaDat> lista=(ArrayList<AgendaDat>)os.readObject();
            for (AgendaDat pessoa : lista) {
                if(pessoa.getDataConsulta().equalsIgnoreCase(dataformatada)){
                //System.out.print("Nome: "+pessoa.getNome()+"\nAgenda: "+pessoa.getDataConsulta()+"Tipo de consulta: "+pessoa.getTipoConsulta());
                    File file=new File("C:/GESP01/Agenda");
                    file.mkdir();
                    File arq=new File("C:/GESP01/Agenda/Agenda.doc");
                    arq.delete();
                    try{
                     arq.createNewFile();                  
                    } catch (IOException ex){
                    }
                    try{
                    FileWriter fileWriter=new FileWriter(arq,true);
                    BufferedWriter escrever =new BufferedWriter(fileWriter);
                    escrever.write("======================================================================\n"
                            + "                           Agenda do dia: "+dataformatada
                            + "\nNID: "+pessoa.getNID()
                            + "\nNome: "+pessoa.getNome()
                            + "\nMetodo: "+pessoa.getMetodo()
                            + "\nTipo de Consulta: "+pessoa.getTipoConsulta()
                            + "");escrever.newLine();
                    escrever.close();
                    fileWriter.close();
            } catch (IOException ex){
            }                
                achou=true;
                 imprimir();
                
              }
              }
              if(achou==false){                  
              JOptionPane.showMessageDialog(null,"AGENDA LIVRE\n","Informacao", JOptionPane.INFORMATION_MESSAGE); 
              }
              os.close();
          } catch (FileNotFoundException ex) {
            Logger.getLogger(Fluxo_AgendaDat.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) { 
            Logger.getLogger(Fluxo_AgendaDat.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
            Logger.getLogger(Fluxo_AgendaDat.class.getName()).log(Level.SEVERE, null, ex);
        }
           
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
        Relatorio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               Fluxo_PacienteDat fluxo= new Fluxo_PacienteDat();
               fluxo.estatistica();
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
               
        FundoLogin.setIcon(new ImageIcon(getClass().getResource("/Imagens/image fundo.png")));
        FundoLogin.setFocusable(false);
        FundoLogin.setPreferredSize(new java.awt.Dimension(1600, 1200));
        getContentPane().add(FundoLogin);
        FundoLogin.setBounds(0, 0, 1600, 666);
    
    }
    public void imprimir(){
        try {
        URI link= new URI("C:/GESP01/Agenda");
        File file=new File("C:/GESP01/Agenda/Agenda.doc");
        //Desktop.getDesktop().print(file);
        Desktop.getDesktop().open(file);        
        } catch (Exception e) {
        }
    }
    
       
}
