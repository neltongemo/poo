
package visao;
import Controle.Fluxo_AgendaDat;
import Controle.Fluxo_PacienteDat;
import javax.swing.*;
import java.io.IOException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.net.URI;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.AgendaDat;
import modelo.PacienteDat;

/**
 *
 * @author Lelifork
 */
public abstract class Tela_1_Registo_Agenda extends JFrame implements ActionListener{
    JLabel FundoLogin = new JLabel();  
    JLabel nomeficha = new JLabel("FORMULÁRIO DA AGENDA");
    JLabel nid = new JLabel("Número do Paciente:");    
    JLabel nome = new JLabel("Nome: ");
    JLabel metodo = new JLabel("Método  de PF:");
    JLabel dataregisto = new JLabel("Data do Registo:"); 
    JLabel dataconsulta = new JLabel("Data da Consulta:"); 
    JLabel Tipo = new JLabel(" Tipo de Consulta:"); 
    
    
    JTextField JTFNID = new JTextField();
    JTextField JTFnome = new JTextField();
    JTextField JTFmetodo = new JTextField();
    JTextField JTFdataregisto = new JTextField();
    JTextField JTFdataconsulta = new JTextField(); 
    
    JComboBox<String> JCtipoconsulta=new JComboBox<String>();       
    String [] arraytipo={"Não definido","Aderencia(1)","Seguimento(...)"};
  
    JButton Salvar = new JButton("Salvar",new ImageIcon(getClass().getResource("/Imagens/save.png")));
    JButton Actualizar = new JButton("Actualizar",new ImageIcon(getClass().getResource("/Imagens/update.png")));
    JButton autentica = new JButton("Verificar",new ImageIcon(getClass().getResource("/Imagens/confirma.png")));
    
    
    Font fonte= new Font("Cambria",Font.PLAIN,15);
    
    public Tela_1_Registo_Agenda(){
    setTitle("GESP01-PAINEL-Registo-Agenda");
    setLayout(null);
    setSize(1000,500);
    setVisible(true);
    setResizable(false);
    setLocationRelativeTo(null);
   
    nomeficha.setFont(new Font("Cambria",Font.BOLD,20)); 
    add(nomeficha);
    nomeficha.setBounds(400, 5, 760, 60);

    nid.setFont(fonte); 
    add(nid);
    nid.setBounds(50, 150, 330, 30);
    add(JTFNID);
    JTFNID.setBounds(200, 150, 60, 40);
    JTFNID.setFont(new Font("Cambria",Font.BOLD,20));
    
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
    
    dataregisto.setFont(fonte); 
    add(dataregisto);
    dataregisto.setBounds(500, 150, 330, 30);
    add(JTFdataregisto);
    JTFdataregisto.setBounds(620, 150, 250, 30);
    JTFdataregisto.setFont(fonte);
    JTFdataregisto.setEditable(false);
    
    dataconsulta.setFont(fonte); 
    add(dataconsulta);
    dataconsulta.setBounds(500, 200, 330, 30);
    add(JTFdataconsulta);
    JTFdataconsulta.setBounds(620, 200, 250, 30);
    JTFdataconsulta.setFont(fonte);
    
    Tipo.setFont(fonte); 
    add(Tipo);
    Tipo.setBounds(500, 250, 330, 30);
    add(JCtipoconsulta);
    JCtipoconsulta.setBounds(620, 250,200, 40);
    JCtipoconsulta.setFont(fonte);
    
   
    for (int i = 0; i <arraytipo.length; i++){
    JCtipoconsulta.addItem(arraytipo[i]);
    } 

    getContentPane().add(Salvar);
    Salvar.setBounds(150, 350, 150, 48);
    Salvar.setContentAreaFilled(false);
    Salvar.setFont(fonte);
    
    getContentPane().add(Actualizar);
    Actualizar.setBounds(350, 350, 150, 48);
    Actualizar.setContentAreaFilled(false);
    Actualizar.setFont(fonte);
   
    
   
    getContentPane().add(autentica);
    autentica.setBounds(280, 150, 170, 40);
    //verifica.setContentAreaFilled(false);
    autentica.setFont(fonte);
    autentica.setForeground(Color.RED);
    autentica.setBackground(Color.DARK_GRAY);
    autentica.setFont(new Font("Cambria",Font.BOLD,20));

    FundoLogin.setIcon(new ImageIcon(getClass().getResource("/Imagens/image fundo.png")));
    FundoLogin.setFocusable(false);
    FundoLogin.setPreferredSize(new Dimension(1600, 1000));
    getContentPane().add(FundoLogin);
    FundoLogin.setBounds(0, 0, 1000, 500);
    autentica.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //---------------------------------- Verificar se existe
                boolean achou=false;
                if(JTFNID.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "\n    NIP NÃO PREENCHIDO", "informação", JOptionPane.ERROR_MESSAGE);    
               }else{
                try {
                    FileInputStream readData = new FileInputStream("C:\\GESP01\\BDGESP02PACIENTE.dat");
                    ObjectInputStream os = new ObjectInputStream(readData);
                     Fluxo_AgendaDat ficheiro=new Fluxo_AgendaDat();
                      AgendaDat p=new AgendaDat();
                      ArrayList<PacienteDat> lista=(ArrayList<PacienteDat>)os.readObject();
                  for (PacienteDat pessoa : lista) {
                  if(pessoa.getNID()==(Integer.parseInt(JTFNID.getText()))){
                     JTFnome.setText(pessoa.getNome());
                     JTFdataregisto.setText(pessoa.getData());
                     JTFmetodo.setText(pessoa.getMetodo());
                     achou=true;
                  }
              }
              if(achou==false){                  
              JOptionPane.showMessageDialog(null,"PACIENTE NÃO REGISTADO NO SISTEMA\n","Informação", JOptionPane.ERROR_MESSAGE); 
              }
              os.close();
          } catch (FileNotFoundException ex) {
              Logger.getLogger(Fluxo_PacienteDat.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) { 
              Logger.getLogger(Fluxo_PacienteDat.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
             Logger.getLogger(Fluxo_PacienteDat.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        }
    });
    
   
    Salvar.addActionListener(new ActionListener() {
            @Override
       public void actionPerformed(ActionEvent e) {
           if(
             (JTFdataconsulta.getText().isEmpty()) 
            || (JCtipoconsulta.getSelectedIndex()==0)){
           JOptionPane.showMessageDialog(null, "\n         FALHA NO REGISTO\nEXISTEM CAMPOS NÃO PREENCHIDOS", "informação", JOptionPane.ERROR_MESSAGE);    
          }else{
        Fluxo_AgendaDat ficheiro=new Fluxo_AgendaDat();
        AgendaDat p=new AgendaDat();
        p.setNID(Integer.parseInt(JTFNID.getText()));
        p.setNome(JTFnome.getText().toUpperCase());
        p.setDataRegisto(JTFdataregisto.getText().toUpperCase());
        p.setDataConsulta(JTFdataconsulta.getText().toUpperCase());
        p.setMetodo(JTFmetodo.getText());
        p.setTipoConsulta(String.valueOf(JCtipoconsulta.getSelectedItem()));
        Fluxo_AgendaDat.create(p);
        JOptionPane.showMessageDialog(null,"AGENDA MARCADA COM SUCESSO");
        limpar();
       } 
       }
    });
    
    Actualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 if
                    ((JTFdataconsulta.getText().isEmpty()) 
                    || (JCtipoconsulta.getSelectedIndex()==0)){
                   JOptionPane.showMessageDialog(null, "\n         FALHA NO REGISTO\nEXISTEM CAMPOS NÃO PREENCHIDOS", "informação", JOptionPane.ERROR_MESSAGE);    
                  }else{
              Fluxo_AgendaDat ficheiro=new Fluxo_AgendaDat();
                AgendaDat p=new AgendaDat();
                p.setNID(Integer.parseInt(JTFNID.getText()));
                p.setNome(JTFnome.getText().toUpperCase());
                p.setDataRegisto(JTFdataregisto.getText().toUpperCase());
                p.setDataConsulta(JTFdataconsulta.getText().toUpperCase());
                p.setMetodo(JTFmetodo.getText());
                p.setTipoConsulta(String.valueOf(JCtipoconsulta.getSelectedItem()));
                Fluxo_AgendaDat.edit(Integer.parseInt(JTFNID.getText()),p);
                JOptionPane.showMessageDialog(null,"AGENDA REMARCADA  COM SUCESSO");
                 limpar();
            }
            }
        });
        
  
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
    public void limpar(){
       JTFNID.setText("");
       JTFnome.setText("");
       JTFdataregisto.setText("");
       JTFdataconsulta.setText("");
       JTFmetodo.setText("");
       JCtipoconsulta.setSelectedIndex(0);
    } 
    
   
}
