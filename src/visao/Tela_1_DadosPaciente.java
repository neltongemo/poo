
package visao;
import Controle.Fluxo_PacienteDat;
import javax.swing.*;
import java.io.IOException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.PacienteDat;

/**
 *
 * @author Lelifork
 */
public abstract class Tela_1_DadosPaciente extends JFrame implements ActionListener{
    JLabel FundoLogin = new JLabel();  
    JLabel nomeficha = new JLabel(" INFORMAÇÕES  DOS PACIENTES REGISTADOS");
    JLabel nid = new JLabel("Número do Paciente:");    
    JLabel nome = new JLabel("Nome: ");
    JLabel metodo = new JLabel("Método  de PF:");
    JLabel dataregisto = new JLabel("Data do Registo:"); 
    JLabel datanacimento = new JLabel("Data de Nascimento:"); 
    JLabel genero = new JLabel("Género :"); 
    JLabel residencia = new JLabel("Residência:"); 
    JLabel contacto = new JLabel("Contacto:"); 
    
    
    JTextField JTFNID = new JTextField();
    JTextField JTFnome = new JTextField();
    JTextField JTFmetodo = new JTextField();
    JTextField JTFdataregisto = new JTextField();
    JTextField JTFdatanascimento = new JTextField(); 
    JTextField JTFsexo=new JTextField();
    JTextField JTFresidencia=new JTextField();
    JTextField JTFcontacto=new JTextField();
    
        
    JMenuBar barra = new JMenuBar();
    JMenu menu=new JMenu("Opções");
    //JMenuItem Sair= new JMenuItem("Sair ");
        
   JButton pesquisa=new JButton("(NIP)",new ImageIcon(getClass().getResource("/Imagens/pesquisaNIP.png")));
   JButton verifica = new JButton("Verificar",new ImageIcon(getClass().getResource("/Imagens/confirma.png")));
    
    
    
    Font fonte= new Font("Cambria",Font.PLAIN,15);
    
    public Tela_1_DadosPaciente(){
    setTitle("GESP01-PAINEL-Pesquisa-Dados-Paciente");
    setLayout(null);
    setSize(1000,500);
    setVisible(true);
    setResizable(false);
    setLocationRelativeTo(null);
   

   // setJMenuBar(barra);
   // barra.add(menu);
   // menu.add(Sair);

    nomeficha.setFont(fonte); 
    add(nomeficha);
    nomeficha.setBounds(350, 5, 760, 60);

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
    
    datanacimento.setFont(fonte); 
    add(datanacimento);
    datanacimento.setBounds(500, 200, 330, 30);
    add(JTFdatanascimento);
    JTFdatanascimento.setBounds(630, 200, 240, 30);
    JTFdatanascimento.setFont(fonte);
    JTFdatanascimento.setEditable(false);
    
    genero.setFont(fonte); 
    add(genero);
    genero.setBounds(500, 250, 330, 30);
    add(JTFsexo);
    JTFsexo.setBounds(620, 250, 250, 30);
    JTFsexo.setFont(fonte);
    JTFsexo.setEditable(false);
    
    
    residencia.setFont(fonte); 
    add(residencia);
    residencia.setBounds(50, 300, 330, 30);
    add(JTFresidencia);
    JTFresidencia.setBounds(200, 300, 250, 30);
    JTFresidencia.setFont(fonte);
    JTFresidencia.setEditable(false);
    
    contacto.setFont(fonte); 
    add(contacto);
    contacto.setBounds(500, 300, 330, 30);
    add(JTFcontacto);
    JTFcontacto.setBounds(620, 300, 250, 30);
    JTFcontacto.setFont(fonte);
    JTFcontacto.setEditable(false);
    
    getContentPane().add(pesquisa);
    pesquisa.setBounds(200, 350, 200, 48);
    pesquisa.setContentAreaFilled(false);
    pesquisa.setFont(new Font("Cambria",Font.BOLD,20));
    
      
    
    getContentPane().add(verifica);
    verifica.setBounds(280, 150, 170, 40);
    //verifica.setContentAreaFilled(false);
    verifica.setFont(fonte);
    verifica.setForeground(Color.RED);
    verifica.setBackground(Color.DARK_GRAY);
    verifica.setFont(new Font("Cambria",Font.BOLD,20));

    FundoLogin.setIcon(new ImageIcon(getClass().getResource("/Imagens/image fundo.png")));
    FundoLogin.setFocusable(false);
    FundoLogin.setPreferredSize(new Dimension(1600, 1000));
    getContentPane().add(FundoLogin);
    FundoLogin.setBounds(0, 0, 1000, 500);
    
    pesquisa.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            limpar();
         }
    });

    verifica.addActionListener(new ActionListener() {
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
                 ArrayList<PacienteDat> lista=(ArrayList<PacienteDat>)os.readObject();
                  for (PacienteDat pessoa : lista) {
                  if(pessoa.getNID()==(Integer.parseInt(JTFNID.getText()))){
                     JTFnome.setText(pessoa.getNome());
                     JTFdataregisto.setText(pessoa.getData());
                     JTFmetodo.setText(pessoa.getMetodo());
                     JTFdatanascimento.setText(pessoa.getDataDeNasciento());
                     JTFsexo.setText(pessoa.getSexo());
                     JTFresidencia.setText(pessoa.getResidencia());
                     JTFcontacto.setText(pessoa.getContacto());
                     achou=true;
                  }
              }
              if(achou==false){                  
              JOptionPane.showMessageDialog(null,"PACIENTE  NÃO  REGISTADO NO SISTEMA\n","informação", JOptionPane.ERROR_MESSAGE); 
            
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
    }
    public void limpar(){
       JTFNID.setText("");
       JTFnome.setText("");
       JTFdataregisto.setText("");
       JTFdatanascimento.setText("");
       JTFmetodo.setText("");
       JTFsexo.setText("");
       JTFcontacto.setText("");
       JTFresidencia.setText("");
    }
    
}
