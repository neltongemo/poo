package modelo;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Armando
 * 
 */
public class PacienteTableModelDat extends AbstractTableModel{

    private ArrayList<PacienteDat> pessoas=new ArrayList();
     private String [] colunas={"NID","Nome do Pacientte","Sexo","Data de Nascimento","Residencia","Data do Registo","Metodo de PF","Contacto"};
    @Override
    public int getRowCount() {
        return pessoas.size();
        
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column]; 
    }
    
    

    @Override
    public int getColumnCount() {
        
        return  colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       
        switch(columnIndex){
            
           case 0: return pessoas.get(rowIndex).getNID();
            case 1: return pessoas.get(rowIndex).getNome();
            case 2: return pessoas.get(rowIndex).getSexo();
            case 3: return pessoas.get(rowIndex).getDataDeNasciento();
           case 4:  return pessoas.get(rowIndex).getResidencia();
           case 5: return pessoas.get(rowIndex).getMetodo();
            case 6: return pessoas.get(rowIndex).getData(); 
            case 7: return pessoas.get(rowIndex).getContacto(); 
          
        }
        return null;
    }

    public void addRow(Object[] object) {
        
    }
    
    
    
    
}