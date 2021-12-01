
package modelo;

import java.io.Serializable;
/**
 *
 * @author Nelton
 */
    public class AtendimentoDat implements Serializable{
        private  String hisorico,dataRegisto,dataConsulta,tipoConsulta;
        private int NID;
	
	public AtendimentoDat(String nome,String metodo,String dataRegisto,String dataConsulta,String tipoConsulta){
       // this.nome=nome;
        this.dataRegisto=dataRegisto;
        this.dataConsulta=dataConsulta;
       // this.metodo=metodo;
        this.tipoConsulta=tipoConsulta;
    }

   
}
