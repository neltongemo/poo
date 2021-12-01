
package modelo;

import java.io.Serializable;
/**
 *
 * @author Nelton
 */
    public class AgendaDat implements Serializable{
        private  String nome,metodo,dataRegisto,dataConsulta,tipoConsulta,HISTORICO,Consultafeita;
        private int NID;
	
	public AgendaDat(String nome,String metodo,String dataRegisto,String dataConsulta,String tipoConsulta){
        this.nome=nome;
        this.dataRegisto=dataRegisto;
        this.dataConsulta=dataConsulta;
        this.metodo=metodo;
        this.tipoConsulta=tipoConsulta;
        this.HISTORICO=HISTORICO;
        this.Consultafeita=Consultafeita;
    }

    public String getConsultafeita() {
        return Consultafeita;
    }

    public void setConsultafeita(String Consultafeita) {
        this.Consultafeita = Consultafeita;
    }

    public String getHISTORICO() {
        return HISTORICO;
    }

    public void setHISTORICO(String HISTORICO) {
        this.HISTORICO = HISTORICO;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    
    public AgendaDat(){
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getDataRegisto() {
        return dataRegisto;
    }

    public void setDataRegisto(String dataRegisto) {
        this.dataRegisto = dataRegisto;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public int getNID() {
        return NID;
    }

    public void setNID(int NID) {
        this.NID = NID;
    }
		
   	
}
