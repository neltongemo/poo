package visao;

import Controle.Fluxo_PacienteDat;
import modelo.PacienteDat;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Lelifork
 */
public class Tela_1_Registo_PacienteDat extends JFrame{
     //----------------------------------------------------------
    Date data = new Date();
    SimpleDateFormat formatar =new SimpleDateFormat("dd/MM/yyyy");
    String dataformatada=formatar.format(data);
    int numeroNID = 2020;
    //----------------------------------------------------------
    //--------------------
    JLabel Dataregisto= new JLabel("                                               Data do registo:");
    JLabel NID = new JLabel("   NÚMERO DO PACIENTE");
    JLabel Nome= new JLabel("   Nome do Paciente:     ");
    JLabel Genero= new JLabel("                                              Género:");
    JLabel Nascimento=new JLabel("   Data de Nascimento: ");
    JLabel Residencia=new JLabel("   Residência:                 ");
    JLabel Contacto=new JLabel("                                               Contacto: ");
    JLabel Metodo= new JLabel ("Metodo de Planeamento Familiar           ");
    
    JRadioButton Preservativo=new JRadioButton("Preservativo");
    JRadioButton Pilula=new JRadioButton("Pilulas-(Toma Diaria)");
    JRadioButton Implante=new JRadioButton("Implante-(3 a 5 anos)");
    JRadioButton Injectavel=new JRadioButton("Injectavel-(3 em 3 Meses)");
    JRadioButton DIU=new JRadioButton("DIU-Disp. intra-uterino(10 a 12 Anos )");
    ButtonGroup grupometodos= new ButtonGroup();
    
    JTextField nid = new JTextField();
    JTextField nome = new JTextField();
    JTextField dataNascimento = new JTextField();
    JTextField residencia = new JTextField();
    JTextField contacto = new JTextField("+258");
    JTextField dataregisto= new JTextField(dataformatada);
    
    JComboBox<String> genero=new JComboBox<String>();
    JComboBox<String> metodo=new JComboBox<String>();       
    String [] arraygenero={"Não Definido","Masculino","Femenino"};
    
    Font fonte= new Font("Cambria",Font.PLAIN,16);
    Font fontemetodo= new Font("Cambria",Font.BOLD,20);
    JMenuBar barra = new JMenuBar();
    JMenu menu=new JMenu("Opções");
    JMenuItem Sair= new JMenuItem("Voltar ");
    
    //---------
    JTable table;    
    JTextField jtfPesquisa;
    
    public Tela_1_Registo_PacienteDat(){
        
        initComponents();
        DefaultTableModel modelo=(DefaultTableModel) table.getModel();
        table.setRowSorter(new TableRowSorter(modelo));
        readJTable();
    }
    public void readJTable(){
        DefaultTableModel modelo=(DefaultTableModel) table.getModel();
        modelo.setNumRows(0);
        for (PacienteDat p : Fluxo_PacienteDat.lista()) {
            modelo.addRow(new Object[]{
            p.getNID(),
            p.getNome(),            
            p.getSexo(),
            p.getDataDeNasciento(),
            p.getResidencia(),
            p.getData(),
            p.getMetodo(),
            p.getContacto(),
            
            });
        }     
    }
    
    public void readJTableSearch(int pessoa){
        DefaultTableModel modelo=(DefaultTableModel) table.getModel();
        modelo.setNumRows(0);
        for (PacienteDat p : Fluxo_PacienteDat.search(pessoa)) {
            modelo.addRow(new Object[]{
            p.getNID(),
            p.getNome(),            
            p.getSexo(),
            p.getDataDeNasciento(),
            p.getResidencia(),
            p.getData(),
            p.getMetodo(),
            p.getContacto(),
            });
        }
    }
    
    public void clean(){
        nid.setText("");
        nome.setText("");
        genero.setSelectedIndex(0);
        dataNascimento.setText("");
        residencia.setText("");
        contacto.setText("+258");
        metodo.setSelectedItem(null);
        dataregisto.setText("    "+dataformatada);
        jtfPesquisa.setText("");
    }
    public void initComponents(){
         
        Point p=new Point();
        setTitle("GESP01-PAINEL-Registo do Paciente");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1350,1000));
        setVisible(true);
        setResizable(false);
        setLocation(10,0);
        
        setJMenuBar(barra);
        barra.add(menu);
        menu.add(Sair);
        
        JPanel jPanel=new JPanel();
        jPanel.setLayout(new GridLayout(2, 0));
        setContentPane(jPanel);
        
          //Panel de fields
        JPanel jPanel1=new JPanel();
        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new GridLayout(6, 0));
        
          //Panel de Jtable
         JPanel jPanel2=new JPanel();
        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new GridLayout(1, 0));
        
        
      //Panels de fields
      
        JPanel jPanelNID=new JPanel();
        jPanelNID.setBackground(new java.awt.Color(255, 255, 255));
        jPanelNID.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        jPanelNID.add(NID);
        jPanelNID.add(nid);
        nid.setFont(fonte);
       
        NID.setFont(fonte);
        nid.setPreferredSize(new Dimension(100, 40));
        nid.setBackground(Color.LIGHT_GRAY);
        nid.setFont(new Font("Cambria",Font.BOLD,35));
        nid.setEditable(false);
        
        JPanel jPanelnome=new JPanel();
        jPanelnome.setBackground(new java.awt.Color(255, 255, 255));
        jPanelnome.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        jPanelnome.add(Nome);
        jPanelnome.add(nome);
        Nome.setFont(fonte);
        nome.setFont(fonte);
        nome.setPreferredSize(new Dimension(385, 30));
        
        Genero.setFont(fonte);
        genero.setFont(fonte);
        for (int i = 0; i <arraygenero.length; i++){
        genero.addItem(arraygenero[i]);
        } 
        jPanelnome.add(Genero);
        jPanelnome.add(genero);
        genero.setPreferredSize(new Dimension(200, 30));
        
        JPanel jPanelnascimento=new JPanel();
        jPanelnascimento.setBackground(new java.awt.Color(255, 255, 255));
        jPanelnascimento.setLayout(new FlowLayout(FlowLayout.LEFT));
        dataNascimento.setPreferredSize(new Dimension(385, 30));
        jPanelnascimento.add(Nascimento);
        jPanelnascimento.add(dataNascimento);
        dataNascimento.setFont(fonte);
        Nascimento.setFont(fonte);
        
        dataregisto.setPreferredSize(new Dimension(100, 30));
        jPanelnascimento.add(Dataregisto);
        jPanelnascimento.add(dataregisto);
        Dataregisto.setFont(fonte);
        dataregisto.setFont(fonte);
        dataregisto.setEditable(false);
          
        JPanel jPanelresidencia=new JPanel();
        jPanelresidencia.setBackground(new java.awt.Color(255, 255, 255));
        jPanelresidencia.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        residencia.setPreferredSize(new Dimension(385, 30));
        jPanelresidencia.add(Residencia);
        jPanelresidencia.add(residencia);
        Residencia.setFont(fonte);
        residencia.setFont(fonte);
        contacto.setPreferredSize(new Dimension(200, 30));
        jPanelresidencia.add(Contacto);
        jPanelresidencia.add(contacto);
        Contacto.setFont(fonte);
        contacto.setFont(fonte);
        
              
       JPanel jPanelpf=new JPanel();
       jPanelpf.setBackground(new java.awt.Color(255, 255, 255));
       jPanelpf.setLayout(new FlowLayout(FlowLayout.LEFT));
       
       jPanelpf.add(Metodo);
       JLabel espaco= new JLabel("                                                                                                                                                                                                                                                                            " );
       jPanelpf.add(espaco);
       jPanelpf. add(DIU);
       jPanelpf.add(Preservativo);
       jPanelpf. add(Implante);
       jPanelpf. add(Injectavel);
       jPanelpf.add(Pilula);
        grupometodos.add(DIU);
        grupometodos.add(Preservativo);
        grupometodos.add(Implante);
        grupometodos.add(Injectavel);
        grupometodos.add(Pilula);
        
        DIU.setFont(fontemetodo);
        Preservativo.setFont(fontemetodo);
        Implante.setFont(fontemetodo);
        Injectavel.setFont(fontemetodo);
        Pilula.setFont(fontemetodo);
        Metodo.setFont(fontemetodo);
        
      
        //--------------------------Painel 7 Botoes-------
         JPanel jPanelBotoes=new JPanel();
         
        jPanelBotoes.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBotoes.setBorder(BorderFactory.createTitledBorder(""));
        jPanelBotoes.setLayout(new FlowLayout(FlowLayout.LEFT));
        jPanelBotoes.setBackground(Color.BLACK);
        
        JButton registar=new JButton(new ImageIcon(getClass().getResource("/Imagens/save.png")));
        registar.setPreferredSize(new Dimension(130, 48));
        jPanelBotoes.add(registar);
        registar.setFont(fonte);
        
        JButton Editar=new JButton(new ImageIcon(getClass().getResource("/Imagens/edit.png")));
        Editar.setPreferredSize(new Dimension(100, 48));
        jPanelBotoes.add(Editar);
        Editar.setFont(fonte);
        JButton Apagar=new JButton(new ImageIcon(getClass().getResource("/Imagens/delete1.png")));
        Apagar.setPreferredSize(new Dimension(100, 48));
        jPanelBotoes.add(Apagar);
        Apagar.setFont(fonte);
        JButton Normalizar=new JButton(new ImageIcon(getClass().getResource("/Imagens/normalizar.png")));
        Normalizar.setPreferredSize(new Dimension(150, 48));
        jPanelBotoes.add(Normalizar);
        Normalizar.setFont(fonte);
        
        JButton Pesquisar=new JButton("(NIP)",new ImageIcon(getClass().getResource("/Imagens/pesquisaNIP.png")));
        Pesquisar.setPreferredSize(new Dimension(150, 48));
        jPanelBotoes.add(new JLabel("                                                                      "));
        jPanelBotoes.add(Pesquisar);
        jtfPesquisa=new JTextField();
        jtfPesquisa.setPreferredSize(new Dimension(200, 48));
        jPanelBotoes.add(jtfPesquisa);
        Pesquisar.setFont(fonte);
        
        //add to fields panel
        jPanel1.add(jPanelNID);
        jPanel1.add(jPanelnome);
        jPanel1.add(jPanelnascimento);
        jPanel1.add(jPanelresidencia);
        jPanel1.add(jPanelpf);
      
        jPanel1.add(jPanelBotoes);
        
        
        
        //Jtable Panel
        String [] colunas={"NID","Nome do Paciente","Sexo","Data de Nascimento","Residencia","Data do Registo","Metodo de PF","Contacto"};
        table=new JTable();
        table.setModel(new DefaultTableModel(colunas,ABORT));
        JScrollPane scroll=new JScrollPane(table);
        jPanel2.add(scroll);
        //add to main panel
        jPanel.add(jPanel1);
        jPanel.add(jPanel2);
        
       //Eventos
      
        
       registar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              if(((nome.getText().isEmpty())
                || (dataNascimento.getText().isEmpty()) 
                || (residencia.getText().isEmpty())
                ||(contacto.getText().isEmpty())
                ||(genero.getSelectedIndex()==0))){
                //||((Implante.isSelected())||(DIU.isSelected())||(Preservativo.isSelected())||(Pilula.isSelected())||(Injectavel.isSelected()))){
              JOptionPane.showMessageDialog(null, "\n         FALHA NO REGISTO\nEXISTEM CAMPOS NÃO PREENCHIDOS", "informação", JOptionPane.ERROR_MESSAGE);    
              }else{
              Fluxo_PacienteDat ficheiro=new Fluxo_PacienteDat ();
              PacienteDat p=new PacienteDat();
                
                p.setNID(Fluxo_PacienteDat .lista().size() + 1);
                p.setSexo(String.valueOf(genero.getSelectedItem()));
                 if(genero.getSelectedIndex()==1){
                    p.setContMasculino(p.getContMasculino()+1);
                }
                if(genero.getSelectedIndex()==2){
                    p.setContFemenino(p.getContFemenino()+1);
                }
                p.setNome(nome.getText().toUpperCase());
                p.setDataDeNasciento(dataNascimento.getText());
                p.setResidencia(residencia.getText().toUpperCase());
                p.setData(dataregisto.getText().toUpperCase());
                p.setContacto(contacto.getText());
                    if(Implante.isSelected()){
                    p.setMetodo("Implante");
                    p.setContImplante(p.getContImplante()+1);
                    }
                    if(Preservativo.isSelected()){
                    p.setMetodo("Preservativo");
                    p.setContPreservativo(p.getContPreservativo()+1);
                    }
                    if(DIU.isSelected()){
                    p.setMetodo("Dispositivo Intra-Uterino");
                    p.setContDiu(p.getContDiu()+1);
                    }
                    if(Injectavel.isSelected()){
                        p.setMetodo("Injectavel");
                        p.setContInjectavel(p.getContInjectavel()+1);
                    }
                    if(Pilula.isSelected()){
                    p.setMetodo("Pilula");
                    p.setContPilula(p.getContPilula()+1);
                    }
                Fluxo_PacienteDat .create(p);
                readJTable();
                clean(); 
            }
                 
            }
            
        });
       
       Apagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Fluxo_PacienteDat.delete(Integer.parseInt(nid.getText()));
                readJTable();
                clean();
            }
        });
       Sair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                new Tela_1_Funcionario() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                };
                dispose();
            }
        });
       
       Editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(((nome.getText().isEmpty())
                || (dataNascimento.getText().isEmpty()) 
                || (residencia.getText().isEmpty())
                ||(contacto.getText().isEmpty())
                ||(genero.getSelectedIndex()==0))){
                //||((!Implante.isSelected())||(!DIU.isSelected())||(!Preservativo.isSelected())||(!Pilula.isSelected())||(!Injectavel.isSelected()))){
              JOptionPane.showMessageDialog(null, "\n         FALHA NO REGISTO\nEXISTEM CAMPOS NÃO PREENCHIDOS", "informação", JOptionPane.ERROR_MESSAGE);    
              }else{
              PacienteDat p=new PacienteDat();
                p.setNID(Integer.parseInt(nid.getText()));
                p.setSexo(String.valueOf(genero.getSelectedItem()));
                if(genero.getSelectedIndex()==1){
                    p.setContMasculino(p.getContMasculino()+1);
                }
                if(genero.getSelectedIndex()==2){
                    p.setContFemenino(p.getContFemenino()+1);
                }
                p.setNome(nome.getText().toUpperCase());
                p.setDataDeNasciento(dataNascimento.getText());
                p.setResidencia(residencia.getText().toUpperCase());
                p.setData(dataregisto.getText().toUpperCase());
                p.setContacto(contacto.getText());
                    if(Implante.isSelected()){
                    p.setMetodo("Implante");
                    p.setContImplante(p.getContImplante()+1);
                    }
                    if(Preservativo.isSelected()){
                    p.setMetodo("Preservativo");
                    p.setContPreservativo(p.getContPreservativo()+1);
                    }
                    if(DIU.isSelected()){
                    p.setMetodo("Dispositivo Intra-Uterino");
                    p.setContDiu(p.getContDiu()+1);
                    }
                    if(Injectavel.isSelected()){
                        p.setMetodo("Injectavel");
                        p.setContInjectavel(p.getContInjectavel()+1);
                    }
                    if(Pilula.isSelected()){
                    p.setMetodo("Pilula");
                    p.setContPilula(p.getContPilula()+1);
                    } 
                Fluxo_PacienteDat.edit(Integer.parseInt(nid.getText()),p);
                readJTable();
                clean(); 
            }
            }
        });
       
        Pesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                readJTableSearch(Integer.parseInt(jtfPesquisa.getText()));
               
            }
        });
        
        Normalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                readJTable();
                clean();
            }
        });
        
       table.addMouseListener(new MouseAdapter() {
            @Override
         public void mouseReleased(MouseEvent e) {
         super.mouseReleased(e); 
         nid.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
         nome.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
         dataNascimento.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
         genero.setSelectedItem(table.getValueAt(table.getSelectedRow(), 2).toString());
         residencia.setText(table.getValueAt(table.getSelectedRow(), 4).toString()); 
         metodo.setSelectedItem(table.getValueAt(table.getSelectedRow(), 6));
         dataregisto.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
         contacto.setText(table.getValueAt(table.getSelectedRow(), 7).toString());

            }        
        });
      
       
       pack();
    }
    
}
