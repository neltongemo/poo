
package visao;

import Controle.Fluxo_PacienteDat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.PacienteDat;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import  java.io.BufferedWriter;
import java.net.URI;

/**
 *
 * @author Nelton
 */
public abstract class FICHA_PF extends JFrame implements ActionListener{
    
    JLabel FundoLogin = new JLabel(); 
    JLabel Nomeficha = new JLabel("GESP01-MOD-SI-02_DADOS DO PACIENTE");
    
    JLabel Dataregisto= new JLabel("Data do registo:");
    JLabel NID = new JLabel("NÚMERO DO PACIENTE: ");
    JLabel Nome= new JLabel("Nome do Paciente: ");
    JLabel Genero= new JLabel("Género: ");
    JLabel Nascimento=new JLabel("Data de Nascimento: ");
    JLabel Residencia=new JLabel("Residência: ");
    JLabel Metodo= new JLabel ("Método de PF: ");
    JLabel resumo= new JLabel(new ImageIcon(getClass().getResource("/Imagens/resumo.png")));
    JLabel nid = new JLabel();
    JLabel nome = new JLabel();
    JLabel dataNascimento = new JLabel();
    JLabel residencia = new JLabel();
    JLabel dataregisto= new JLabel();
    JLabel sexo= new JLabel();
    JLabel metodo = new JLabel();
    JLabel addi= new JLabel();
    
   
    JButton imprimir = new JButton("Imprimir",new ImageIcon(getClass().getResource("/Imagens/printer.png")));
    
    Font fonte= new Font("Cambria",Font.PLAIN,16);
    Font fonte1= new Font("Cambria",Font.PLAIN,20);

    
    public FICHA_PF(){
        setTitle("GESP01-PAINEL-Ficha de seguimento do Paciente");
        setLayout(null);
        setSize(1000,500);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
       
        add(NID);
        add(Nome);
        add(Dataregisto);   
        add(Genero);
        add(Nascimento);
        add(Residencia);
        add(Metodo);

        Nomeficha.setFont(fonte1); 
        add(Nomeficha);
        Nomeficha.setBounds(300, 20, 1500, 30);

        imprimir.setFont(fonte1);
        add(imprimir);
        imprimir.setBounds(700, 350, 200, 70);
        imprimir.setContentAreaFilled(false);
       
        
        
        NID.setBounds(100, 100, 220, 50);
        Nome.setBounds(100,150, 250,30);
        Genero.setBounds(100,200,250,30);
        Nascimento.setBounds(100,250,250,30);
        Residencia.setBounds(100,300,250,30);
        Dataregisto.setBounds(100,350,330,30);
        Metodo.setBounds(100,400, 500,30);
     
        NID.setFont(fonte1);
        Metodo.setFont(fonte1);
        Residencia.setFont(fonte);       
        Nascimento.setFont(fonte);
        Genero.setFont(fonte);
        Nome.setFont(fonte);
        Dataregisto.setFont(fonte);
        
        add(nid);
        add(nome);
        add(dataregisto);   
        add(sexo);
        add(dataNascimento);
        add(residencia);
        add(metodo);
        
        nid.setBounds(350, 100, 150, 50);
        nid.setFont(new Font("Cambria",Font.BOLD,50));
        nome.setBounds(250,150, 250,30);
        sexo.setBounds(250,200,250,30);
        dataNascimento.setBounds(250,250,250,30);
        residencia.setBounds(250,300,250,30);
        dataregisto.setBounds(250,350,330,30);
        metodo.setBounds(250,400, 500,30);
        
        
        metodo.setFont(new Font("Cambria",Font.BOLD,25));
        residencia.setFont(fonte);       
        dataNascimento.setFont(fonte);
        sexo.setFont(fonte);
        nome.setFont(fonte);
        dataregisto.setFont(fonte);
        
       add(resumo);
       resumo.setBounds(670, 200, 250, 150);
        
        
        FundoLogin.setIcon(new ImageIcon(getClass().getResource("/Imagens/image fundo.png")));
        FundoLogin.setFocusable(false);
        FundoLogin.setPreferredSize(new Dimension(1600, 1200));
        getContentPane().add(FundoLogin);
        FundoLogin.setBounds(0, 0, 1600, 666);
        int paciente =Integer.parseInt(JOptionPane.showInputDialog("NÚMERO DO PACIENTE"));
         boolean achou=false;
          try {
            
            FileInputStream readData = new FileInputStream("C:\\GESP01\\BDGESP02PACIENTE.dat");
            ObjectInputStream os = new ObjectInputStream(readData);
              
              ArrayList<PacienteDat> lista=(ArrayList<PacienteDat>)os.readObject();
              for (PacienteDat pessoa : lista) {
                  if(pessoa.getNID()==(paciente)){
                     nid.setText(String.valueOf(pessoa.getNID()));
                     nome.setText(pessoa.getNome());
                     sexo.setText(pessoa.getSexo());
                     dataNascimento.setText(pessoa.getDataDeNasciento());
                     residencia.setText(pessoa.getResidencia());
                     dataregisto.setText(pessoa.getData());
                     metodo.setText(pessoa.getMetodo());
                     achou=true;
                  }

              }
              if(achou==false){
              JOptionPane.showMessageDialog(null,"PACIENTE NÃO  REGISTADO NO SISTEMA\n","Informações", JOptionPane.ERROR_MESSAGE);
              
              new Tela_1_Funcionario() {
                  @Override
                  public void actionPerformed(ActionEvent ae) {
                    }
              };
              dispose();
              }
              os.close();
          } catch (FileNotFoundException ex) {
              Logger.getLogger(Fluxo_PacienteDat.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) { 
              Logger.getLogger(Fluxo_PacienteDat.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
             Logger.getLogger(Fluxo_PacienteDat.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        imprimir.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent evt) {
            File file=new File("C:/GESP01/imprimir");
            file.mkdir();
           File arq=new File("C:/GESP01/imprimir/imprimir.doc");//pode ter varias extencoes
           try{
             arq.delete();
             arq.createNewFile();                  
            } catch (IOException ex){
            }
            // escrever num arquivo
                    try{
                    FileWriter fileWriter=new FileWriter(arq,true);
                    BufferedWriter escrever =new BufferedWriter(fileWriter);
                    escrever.write("======================================================================\n"
                            + "                           MODO-SI-02A-CARTÃO DO PACIENTE"
                            + "\n\nNUMERO DO PACIENTE: "+nid.getText()
                            + "\nNome do Paciente: "+ nome.getText()
                            + "\nGenero: "+sexo.getText()
                            + "\nData de Nascimento:  "+dataNascimento.getText()
                            + "\nResidencia: "+residencia.getText()
                            + "\nData do registo: "+dataregisto.getText()
                            + "\nMetodo do Planeamento Familiar: "+metodo.getText()
                            + "\n\n\n                        DATAS DAS CONSULTAS DE SEGUIMENTO"
                                    + "\n\nData(Consulta 1):____________"
                                    + "\n\nInformacao:___________________________________________________________"
                                    + "\n\n\n   Assinatura"
                                    + "\n_________________________"

                                     + "\n\nData(Consulta 2):____________"
                                    + "\n\nInformacao:___________________________________________________________"
                                    + "\n\n\n   Assinatura"
                                    + "\n_________________________"
                                     + "\n\nData(Consulta 3):____________"
                                    + "\n\nInformacao:___________________________________________________________"
                                    + "\n\n\n   Assinatura"
                                    + "\n_________________________"
                                     + "\n\nData(Consulta 4):____________"
                                    + "\n\nInformacao:___________________________________________________________"
                                    + "\n\n\n   Assinatura"
                                    + "\n_________________________"
                                     + "\n\nData(Consulta 5):____________"
                                    + "\n\nInformacao:___________________________________________________________"                                   
                                    + "\n\n\n   Assinatura"
                                    + "\n_________________________"
                                    + "\n========================================================================="
                            + "");escrever.newLine();
                    escrever.close();
                    fileWriter.close();
            } catch (IOException ex){
            }
          imprimir();
        }
    });       
    }
    
    public void imprimir(){
        try {
        URI link= new URI("C:/GESP01/imprimir");
        File file=new File("C:/GESP01/imprimir/imprimir.doc");
        //Desktop.getDesktop().print(file);
        Desktop.getDesktop().open(file);        
        } catch (Exception e) {
        }
    }
    
    public void limparcampos(){
        nid.setText("");
        nome.setText("");
        sexo.setText("");
        dataNascimento.setText("");
        residencia.setText("");
        dataregisto.setText("");
        metodo.setText("");
    }
    
}
    
