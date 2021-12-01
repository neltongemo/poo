package Controle;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.AgendaDat;


/**
 *
 * @author armando
 */
public class Fluxo_AgendaDat {
     static File directorio=new File("C:\\GESP01");
     File bancoDados=new File("C:\\GESP01\\BDGESP01_AGENDA.dat");
 
    //
    public void CaminhoPrincipal(){

        if(directorio.exists()){
           System.out.print("Diretorio OK!");
        }else{
            directorio.mkdir();
        }
        if(bancoDados.exists()){
           System.out.print("Banco de dados OK!");
    
        }else{
            try {
                bancoDados.createNewFile();
                ArrayList<AgendaDat> lista=new ArrayList();
              ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(bancoDados));
              objectOutputStream.writeObject(lista);
              objectOutputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(Fluxo_AgendaDat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
     public static void create(AgendaDat p){
        ArrayList<AgendaDat> lista=new ArrayList();
         lista= (ArrayList<AgendaDat>)lista().clone();
         lista.add(p);
          try {
              File bancoDados=new File("C:\\GESP01\\BDGESP01_AGENDA.dat");
              ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(bancoDados));
              objectOutputStream.writeObject(lista);
              objectOutputStream.close();
              System.out.println("Salvo com sucesso"); 
          } catch (FileNotFoundException ex) {
              Logger.getLogger(Fluxo_AgendaDat.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
              Logger.getLogger(Fluxo_AgendaDat.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    public static void delete(int id){
        ArrayList<AgendaDat> lista=new ArrayList();
         lista= (ArrayList<AgendaDat>)lista().clone();
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getNID()==id){
                lista.remove(i);
            }
        }
          try {
              File bancoDados=new File("C:\\GESP01\\BDGESP01_AGENDA.dat");
              ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(bancoDados));
              objectOutputStream.writeObject(lista);
              objectOutputStream.close();
              System.out.println("Salvo com sucesso");
              
          } catch (FileNotFoundException ex) {
              Logger.getLogger(Fluxo_AgendaDat.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
              Logger.getLogger(Fluxo_AgendaDat.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    
     public static void edit(int id,AgendaDat p){
        ArrayList<AgendaDat> lista=new ArrayList();
         lista= (ArrayList<AgendaDat>)lista().clone();
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getNID()==id){
                lista.remove(i);
                lista.add(p);
            }
        }
        
          try {
              File bancoDados=new File("C:\\GESP01\\BDGESP01_AGENDA.dat");
              ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(bancoDados));
              objectOutputStream.writeObject(lista);
              objectOutputStream.close();
              System.out.println("Salvo com sucesso");
              
          } catch (FileNotFoundException ex) {
              Logger.getLogger(Fluxo_AgendaDat.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
              Logger.getLogger(Fluxo_AgendaDat.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    
    public static  ArrayList<AgendaDat> search(String paciente){
        ArrayList<AgendaDat> lista=new ArrayList();
         lista= (ArrayList<AgendaDat>)lista().clone();
        for (int i = 0; i < lista.size(); i++) {
            if(!(lista.get(i).getNome().contentEquals(paciente.toUpperCase()))){
                lista.remove(i);
            }
        }
        return lista;
    }
    
    public static ArrayList<AgendaDat> lista(){
        ArrayList<AgendaDat> lista=new ArrayList();
          try {
            FileInputStream readData = new FileInputStream("C:\\GESP01\\BDGESP01_AGENDA.dat");
            ObjectInputStream os = new ObjectInputStream(readData);
              
              lista=(ArrayList<AgendaDat>)os.readObject();
                   
             os.close();
              
          } catch (FileNotFoundException ex) {
              Logger.getLogger(Fluxo_AgendaDat.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) { 
              Logger.getLogger(Fluxo_AgendaDat.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
             Logger.getLogger(Fluxo_AgendaDat.class.getName()).log(Level.SEVERE, null, ex);
         }
        
          return lista;
        
    }
    
    public static void  listas(){
          try {
            
            FileInputStream readData = new FileInputStream("C:\\GESP01\\BDGESP01_AGENDA.dat");
            ObjectInputStream os = new ObjectInputStream(readData);
              
              ArrayList<AgendaDat> lista=(ArrayList<AgendaDat>)os.readObject();
              for (AgendaDat pessoa : lista) {
                  System.out.println("Nome:"+pessoa.getNome());
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
