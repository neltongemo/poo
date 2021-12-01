
package modelo;

import java.io.Serializable;
/**
 *
 * @author Nelton
 */
    public class PacienteDat implements Serializable{
        private  String nome,residencia,sexo,metodo,dataDeNasciento,data,contacto;
        private int NID, contDiu,contPilula,contImplante,contPreservativo,contInjectavel,contMasculino,contFemenino;
	
	public PacienteDat(String nome,String residencia,String sexo,String metodo,String dataConsulta,String tipoConsulta,String contacto,String dataDeNasciento,String data){
        this.nome=nome;
        this.sexo=sexo;
        this.dataDeNasciento=dataDeNasciento;
        this.residencia=residencia;
        this.data=data;
        this.contacto=contacto;
       
    }

    public int getContDiu() {
        return contDiu;
    }

    public void setContDiu(int contDiu) {
        this.contDiu = contDiu;
    }

    public int getContPilula() {
        return contPilula;
    }

    public void setContPilula(int contPilula) {
        this.contPilula = contPilula;
    }

    public int getContImplante() {
        return contImplante;
    }

    public void setContImplante(int contImplante) {
        this.contImplante = contImplante;
    }

    public int getContPreservativo() {
        return contPreservativo;
    }

    public void setContPreservativo(int contPreservativo) {
        this.contPreservativo = contPreservativo;
    }

    public int getContInjectavel() {
        return contInjectavel;
    }

    public void setContInjectavel(int contInjectavel) {
        this.contInjectavel = contInjectavel;
    }

    public int getContMasculino() {
        return contMasculino;
    }

    public void setContMasculino(int contMasculino) {
        this.contMasculino = contMasculino;
    }

    public int getContFemenino() {
        return contFemenino;
    }

    public void setContFemenino(int contFemenino) {
        this.contFemenino = contFemenino;
    }

   
    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    public PacienteDat(){
    }
		
    public void setNome(String nome){
	this.nome=nome;
	}

    public String getData() {
        return data;
    }

    public int getNID() {
        return NID;
    }

    public void setNID(int nid) {
        this.NID = nid;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }
	public void setResidencia(String residencia){
	this.residencia=residencia;
	}
	public void setSexo(String sexo){
	this.sexo=sexo;
	}
	
	
	public 	String getNome(){
	return nome;
	}
	public 	String getResidencia(){
	return residencia;
	}
	public 	String getSexo(){
	return sexo;		
	}

    public String getDataDeNasciento() {
        return dataDeNasciento;
    }

    public void setDataDeNasciento(String dataDeNasciento) {
        this.dataDeNasciento = dataDeNasciento;
    }		
}
