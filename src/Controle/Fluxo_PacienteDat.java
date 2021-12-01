package Controle;
 
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URI;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.PacienteDat;


/**
 *
 * @author armando
 */
public class Fluxo_PacienteDat {
     static File directorio=new File("C:\\GESP01");
     File bancoDados=new File("C:\\GESP01\\BDGESP02PACIENTE.dat");
      
    
    //
    public void CaminhoPrincipal(){

        if(directorio.exists()){
           System.out.print("Directorio OK!");
        }else{
            directorio.mkdir();
        }
        if(bancoDados.exists()){
           System.out.print("Base de dados OK!");
    
        }else{
            try {
                bancoDados.createNewFile();
                ArrayList<PacienteDat> lista=new ArrayList();
              ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(bancoDados));
              objectOutputStream.writeObject(lista);
              objectOutputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(Fluxo_PacienteDat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
     public static void create(PacienteDat p){
        ArrayList<PacienteDat> lista=new ArrayList();
         lista= (ArrayList<PacienteDat>)lista().clone();
         lista.add(p);
          try {
              File bancoDados=new File("C:\\GESP01\\BDGESP02PACIENTE.dat");
              ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(bancoDados));
              objectOutputStream.writeObject(lista);
              objectOutputStream.close();
              System.out.println("Registado com sucesso"); 
          } catch (FileNotFoundException ex) {
              Logger.getLogger(Fluxo_PacienteDat.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
              Logger.getLogger(Fluxo_PacienteDat.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    public static void delete(int id){
        ArrayList<PacienteDat> lista=new ArrayList();
         lista= (ArrayList<PacienteDat>)lista().clone();
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getNID()==id){
                lista.remove(i);
            }
        }
          try {
              File bancoDados=new File("C:\\GESP01\\BDGESP02PACIENTE.dat");
              ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(bancoDados));
              objectOutputStream.writeObject(lista);
              objectOutputStream.close();
              System.out.println("Registado com sucesso");
              
          } catch (FileNotFoundException ex) {
              Logger.getLogger(Fluxo_PacienteDat.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
              Logger.getLogger(Fluxo_PacienteDat.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    
     public static void edit(int id,PacienteDat p){
        ArrayList<PacienteDat> lista=new ArrayList();
         lista= (ArrayList<PacienteDat>)lista().clone();
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getNID()==id){
                lista.remove(i);
                lista.add(p);
            }
        }
        
          try {
              File bancoDados=new File("C:\\GESP01\\BDGESP02PACIENTE.dat");
              ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(bancoDados));
              objectOutputStream.writeObject(lista);
              objectOutputStream.close();
              System.out.println("Registado com sucesso");
              
          } catch (FileNotFoundException ex) {
              Logger.getLogger(Fluxo_PacienteDat.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
              Logger.getLogger(Fluxo_PacienteDat.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    
    public static  ArrayList<PacienteDat> search(int paciente){
        ArrayList<PacienteDat> lista=new ArrayList();
         lista= (ArrayList<PacienteDat>)lista().clone();
        for (int i = 0; i < lista.size(); i++) {
            if(!(lista.get(i).getNID()==(paciente))){
                lista.remove(i);
            }
        }
        return lista;
    }
    
    public static ArrayList<PacienteDat> lista(){
        ArrayList<PacienteDat> lista=new ArrayList();
          try {
            FileInputStream readData = new FileInputStream("C:\\GESP01\\BDGESP02PACIENTE.dat");
            ObjectInputStream os = new ObjectInputStream(readData);
              
              lista=(ArrayList<PacienteDat>)os.readObject();
                   
             os.close();
              
          } catch (FileNotFoundException ex) {
              Logger.getLogger(Fluxo_PacienteDat.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) { 
              Logger.getLogger(Fluxo_PacienteDat.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
             Logger.getLogger(Fluxo_PacienteDat.class.getName()).log(Level.SEVERE, null, ex);
         }
        
          return lista;
        
    }
    
    public static void  listas(){
          try {
            
            FileInputStream readData = new FileInputStream("C:\\GESP01\\BDGESP02PACIENTE.dat");
            ObjectInputStream os = new ObjectInputStream(readData);
              
              ArrayList<PacienteDat> lista=(ArrayList<PacienteDat>)os.readObject();
              for (PacienteDat pessoa : lista) {
                  System.out.println("Nome:"+pessoa.getNome());
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
     public static  ArrayList<PacienteDat> estatistica(){
        int DIU=0,implante=0,preservativo=0,injetavel=0,pilulas=0,masculino=0,femenino=0;
        
        ArrayList<PacienteDat> lista=new ArrayList();
        lista= (ArrayList<PacienteDat>)lista().clone();
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getContFemenino()==1){femenino=femenino+1;}
            if(lista.get(i).getContMasculino()==1){masculino=masculino+1;}   
            if(lista.get(i).getContDiu()==1){DIU=DIU+1;}  
            if(lista.get(i).getContImplante()==1){implante=implante+1;}  
            if(lista.get(i).getContInjectavel()==1){injetavel=injetavel+1;}  
            if(lista.get(i).getContPreservativo()==1){preservativo=preservativo+1;}  
            if(lista.get(i).getContPilula()==1){pilulas=pilulas+1;}     
        }
           File file=new File("C:/GESP01/Estatisticas");
           file.mkdir();
           File arq=new File("C:/GESP01/Estatisticas/Estatistica.doc");//pode ter varias extencoes
           try{
             arq.delete();
             arq.createNewFile();                  
            } catch (IOException ex){
            }
           try{
                    FileWriter fileWriter=new FileWriter(arq,true);
                    BufferedWriter escrever =new BufferedWriter(fileWriter);
                    escrever.write("======================================================================\n"
                    + "        RELATÓRIO ESTATÍSTICO DAS REALIZAÇÕES(DADOS CUMULATIVOS)\n\n "
                    + "---------------------------------------------------------------------"
                    +"\nTotal Femenino:    "+femenino
                    +"\nTotal Masculino:   "+masculino
                    +"\n---------------------------------------------------------------------"
                    +"\nTOTAL PACIENTES:   "+(femenino+masculino)
                    +"\n---------------------------------------------------------------------\n\n"
                            + "               DISTRIBUIÇÃO POR METODOS\n"
                    + "\n-----------------------------------------------------------------------"      
                    +"\nMETODO                           |   TOTAL DE PACIENTES   "
                    + "\n-----------------------------------------------------------------------"  
                    + "\nDIU:                             |      "+DIU
                    + "\n-----------------------------------------------------------------------"
                    +"\nImplante:                        |      "+implante
                    + "\n-----------------------------------------------------------------------"  
                    +"\nInjectavel:                      |      "+injetavel
                    + "\n-----------------------------------------------------------------------"  
                    +"\nPilulas:                         |      "+pilulas
                    + "\n-----------------------------------------------------------------------"  
                    +"\nPreservativo:                    |      "+preservativo
                    + "\n-----------------------------------------------------------------------"
                    + "\nTOTAL:                            |      "+(DIU+implante+injetavel+pilulas+preservativo) 
                    +"\n========================================================================="
                    );
                    escrever.close();
                    fileWriter.close();
                    
            } catch (IOException ex){
            }
           
           /*
         System.out.println("Total Femenino: "+femenino);
         System.out.println("Total Masculino: "+masculino);
         System.out.println("DIU: "+DIU);
         System.out.println("implante: "+implante);
         System.out.println("Injectavel: "+injetavel);
         System.out.println("pilulas: "+pilulas);
         System.out.println("preservativo: "+preservativo);
*/      try {
        URI link= new URI("C:/GESP01/Estatisticas");
       File file1=new File("C:/GESP01/Estatisticas/Estatistica.doc");//pode ter varias extencoes
        //Desktop.getDesktop().print(file);
        Desktop.getDesktop().open(file1);        
        } catch (Exception e) {
        }
        return lista;

    }
       
}
