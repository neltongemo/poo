
package visao;
import Controle.Fluxo_AgendaDat;
import javax.swing.*;
import java.io.IOException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.AgendaDat;
import modelo.PacienteDat;

/**
 *
 * @author Lelifork
 */
public abstract class Tela_1_ConsultaSeguinte extends JFrame implements ActionListener{
    JLabel FundoLogin = new JLabel();  
    JLabel nomeficha = new JLabel("FORMULARIO ATENDIMENTO_CONSULTAS SEGUINTES");
    JLabel nid = new JLabel("Número do Paciente:");    
    JLabel nome = new JLabel("Nome: ");
    JLabel metodo = new JLabel("Método de PF:");
    JLabel dataconsulta = new JLabel("Data da Consulta:"); 
    JLabel Historico = new JLabel("História:"); 
     JLabel Tipo = new JLabel(" NOVO METODO:");
      JLabel proximaConsulta = new JLabel(" Data Proxima Consulta:");
     
    JCheckBox feito = new JCheckBox("Consulta Feita"); 
    JCheckBox troca = new JCheckBox("Troca de Metodo");
    JCheckBox continua = new JCheckBox("Continuação");
     
    
    JTextField JTFNID = new JTextField();
    JTextField JTFnome = new JTextField();
    JTextField JTFmetodo = new JTextField();
    JTextField JTFdataconsulta = new JTextField();
    JTextPane JTFhistorico = new JTextPane(); 
     JTextField JTFproxima = new JTextField();
    
    
    JComboBox<String> JCtipometodo=new JComboBox<String>();       
    String [] arraytipo={"Não definido","Implante","Preservativo","Dispositivo Intra-Uterino","Injectavel","Pilula"};
  
        
    JButton Salvar = new JButton("Salvar",new ImageIcon(getClass().getResource("/Imagens/save.png")));
    JButton proximo = new JButton(new ImageIcon(getClass().getResource("/Imagens/next.png")));
    JButton sair = new JButton(new ImageIcon(getClass().getResource("/Imagens/exit.png")));
    JButton autentica = new JButton("Verificar",new ImageIcon(getClass().getResource("/Imagens/confirma.png")));
      JButton DadosConsultaAnterior = new JButton("Histórico",new ImageIcon(getClass().getResource("/Imagens/historico.png")));
    //----------------------------------------------------------
    Date data = new Date();
    SimpleDateFormat formatar =new SimpleDateFormat("dd/MM/yyyy");
    String dataformatada=formatar.format(data);
    int numeroNID = 2020;
    //----------------------------------------------------------
    
    Font fonte= new Font("Cambria",Font.PLAIN,15);
    
    public Tela_1_ConsultaSeguinte(){
    setTitle("GESP01-PAINEL-Registo-Consulta");
    setLayout(null);
    setSize(1600,1000);
    setVisible(true);
    setResizable(false);
    setLocationRelativeTo(null);
   

   // setJMenuBar(barra);
   // barra.add(menu);
   // menu.add(Sair);

    nomeficha.setFont(new Font("Cambria",Font.BOLD,30)); 
    add(nomeficha);
    nomeficha.setBounds(350, 5, 760, 60);
    
    add(feito);
    feito.setBounds(50,450,150,30);
    //feito.setSelected(false);
    feito.setFont(fonte);
    
    add(troca);
    troca.setBounds(50,300,150,30);
    //feito.setSelected(false);
    troca.setFont(fonte);
   // troca.setBackground(Color.GREEN);
    add(continua);
    //continua.setBounds(50,330,150,30);
    //feito.setSelected(false);
    //continua.setFont(fonte);
    //continua.setBackground(Color.BLUE);
    
   
    
    nid.setFont(fonte); 
    add(nid);
    nid.setBounds(50, 150, 330, 30);
    add(JTFNID);
    JTFNID.setBounds(200, 150, 60, 40);
    JTFNID.setFont(new Font("Cambria",Font.BOLD,20));
    
    DadosConsultaAnterior.setFont(new Font("Cambria",Font.BOLD,25)); 
    add(DadosConsultaAnterior);
    DadosConsultaAnterior.setBounds(900, 130, 250, 70);
    //DadosConsultaAnterior.setContentAreaFilled(false);
    
    
    nome.setFont(fonte); 
    add(nome);
    nome.setBounds(50, 200, 330, 30);
    add(JTFnome);
    JTFnome.setBounds(200, 200, 250, 30);
    JTFnome.setFont(fonte);
    JTFnome.setEditable(false);
    
    metodo.setFont(fonte); 
    add(metodo);
    metodo.setBounds(50, 250, 330, 30);
    add(JTFmetodo);
    JTFmetodo.setBounds(200, 250, 250, 30);
    JTFmetodo.setFont(fonte);
    JTFmetodo.setEditable(false);
    
    dataconsulta.setFont(fonte); 
    add(dataconsulta);
    dataconsulta.setBounds(500, 150, 330, 30);
    add(JTFdataconsulta);
    JTFdataconsulta.setBounds(620, 150, 250, 30);
    JTFdataconsulta.setFont(fonte);
    JTFdataconsulta.setEditable(false);
    
    proximaConsulta.setFont(fonte); 
    add(proximaConsulta);
    proximaConsulta.setBounds(50, 400, 330, 30);
    add(JTFproxima);
    JTFproxima.setBounds(220, 400, 230, 30);
    JTFproxima.setFont(fonte);
    
    Historico.setFont(fonte); 
    add(Historico);
    Historico.setBounds(500, 200, 330, 30);
    add(JTFhistorico);
    JTFhistorico.setBounds(560, 200,750, 290);
    JTFhistorico.setFont(fonte);
    JTFhistorico.setBackground(Color.cyan);
    
    Tipo.setFont(fonte); 
    add(Tipo);
    Tipo.setBounds(50, 350, 330, 30);
    add(JCtipometodo);
    JCtipometodo.setBounds(200, 350,250, 40);
    JCtipometodo.setFont(fonte);
    

    for (int i = 0; i <arraytipo.length; i++){
    JCtipometodo.addItem(arraytipo[i]);
    } 

    getContentPane().add(Salvar);
    Salvar.setBounds(200, 550, 50, 48);
   // Salvar.setContentAreaFilled(false);
    Salvar.setFont(fonte);
    
    getContentPane().add(proximo);
    proximo.setBounds(300, 550, 50, 48);
   // proximo.setContentAreaFilled(false);
    proximo.setFont(fonte);
    
    getContentPane().add(sair);
    sair.setBounds(400, 550, 50, 48);
    //sair.setContentAreaFilled(false);
    sair.setFont(fonte);

    getContentPane().add(autentica);
    autentica.setBounds(280, 150, 170, 40);
    autentica.setFont(fonte);
    autentica.setForeground(Color.RED);
    autentica.setBackground(Color.DARK_GRAY);
    autentica.setFont(new Font("Cambria",Font.BOLD,20));

    FundoLogin.setIcon(new ImageIcon(getClass().getResource("/Imagens/image fundo.png")));
    FundoLogin.setFocusable(false);
    FundoLogin.setPreferredSize(new Dimension(1600, 1000));
    getContentPane().add(FundoLogin);
    FundoLogin.setBounds(0, 0, 1600, 1000);
    autentica.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //---------------------------------- Verificar se existe
                boolean achou=false;
                if(JTFNID.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "\n    NIP NÃO PREENCHIDO", "informação", JOptionPane.ERROR_MESSAGE);    
               }else{
                try {
                    FileInputStream readData = new FileInputStream("C:\\GESP01\\BDGESP01_AGENDA.dat");
                    ObjectInputStream os = new ObjectInputStream(readData);
                     Fluxo_AgendaDat ficheiro=new Fluxo_AgendaDat();
                      AgendaDat p=new AgendaDat();
                      ArrayList<AgendaDat> lista=(ArrayList<AgendaDat>)os.readObject();
                  for (AgendaDat pessoa : lista) {
                  if(pessoa.getDataConsulta().equalsIgnoreCase(dataformatada)){
                     JTFnome.setText(pessoa.getNome());
                     JTFmetodo.setText(pessoa.getMetodo());
                     JTFdataconsulta.setText(pessoa.getDataConsulta());
                     achou=true;
                  }
              }
              if(achou==false){                  
              JOptionPane.showMessageDialog(null,"PACIENTE NÃO REGISTADO NA AGENDA\n","Informação", JOptionPane.ERROR_MESSAGE); 
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
        }
    });
    DadosConsultaAnterior.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //---------------------------------- Verificar se existe
                boolean achou=false;
                try {
                    FileInputStream readData = new FileInputStream("C:\\GESP01\\BDGESP01_AGENDA.dat");
                    ObjectInputStream os = new ObjectInputStream(readData);
                     Fluxo_AgendaDat ficheiro=new Fluxo_AgendaDat();
                      AgendaDat p=new AgendaDat();
                      ArrayList<AgendaDat> lista=(ArrayList<AgendaDat>)os.readObject();
                  for (AgendaDat pessoa : lista) {
                  if(pessoa.getNID()==(Integer.parseInt(JTFNID.getText()))){
                      limpar();
                     JTFhistorico.setText(pessoa.getHISTORICO());
                     achou=true;
                  }
              }
              if(achou==false){                  
              JOptionPane.showMessageDialog(null,"PACIENTE NÃO REGISTADO NA AGENDA\n","Informação", JOptionPane.ERROR_MESSAGE); 
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
    
    Salvar.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
           if((JTFhistorico.getText().isEmpty()) 
            || (JTFproxima.getText().isEmpty())){
           JOptionPane.showMessageDialog(null, "\n         FALHA NO REGISTO\nEXISTEM CAMPOS NÃO PREENCHIDOS", "informação", JOptionPane.ERROR_MESSAGE);    
          }else{
        Fluxo_AgendaDat ficheiro=new Fluxo_AgendaDat();
        AgendaDat p=new AgendaDat();
        PacienteDat paciente=new PacienteDat();
        p.setNID(Integer.parseInt(JTFNID.getText()));
        p.setNome(JTFnome.getText().toUpperCase());
        if(troca.isSelected()&&JCtipometodo.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(null, "SELECIONE O METODO", "informação", JOptionPane.ERROR_MESSAGE);    
            p.setMetodo(String.valueOf(JCtipometodo.getSelectedItem()));
        }else{
            p.setMetodo(JTFmetodo.getText());
        }
        p.setTipoConsulta("Seguimento");
        p.setDataConsulta(JTFproxima.getText().toUpperCase());
        p.setHISTORICO(JTFhistorico.getText());
        if(feito.isSelected()){
            p.setConsultafeita("Feito");
        }
        
        Fluxo_AgendaDat.edit(Integer.parseInt(JTFNID.getText()),p);
        
        JOptionPane.showMessageDialog(null,"Consulta Efectuada Com Sucesso");
        limpar();
       }
       }
    });
    
  proximo.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
        limpar();
       }    
    });         
       

    sair.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           new Tela_1_Atendimento() {
               @Override
               public void actionPerformed(ActionEvent ae) {
                   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
               }
           };
           dispose();
        }
    });

    }
       
   
    public void limpar(){
       JTFNID.setText("");
       JTFnome.setText("");
       JTFdataconsulta.setText("");
       JTFmetodo.setText("");
    } 
 
   
}
