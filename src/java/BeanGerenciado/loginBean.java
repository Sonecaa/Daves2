/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanGerenciado;

import classes.Farmacia;
import classes.Medico;
import classes.Paciente;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Marcelo
 */
@ManagedBean(name = "LoginBean")
@SessionScoped
public class loginBean {
    
    private int option;
    
    private Paciente paciente;
    private Medico medico;
    private Farmacia farmacia;
    
    private List<Paciente> listPaciente;
    private List<Medico> listMedico;
    private List<Farmacia> listFarmacia;
    
    private String login;
    private String senha;

    public void addLogin(){
        if(option == 1){
            listPaciente.add(paciente);
            paciente = new Paciente();
        }
        if(option == 2){
            listMedico.add(medico);
            medico = new Medico();
        }
        if(option == 3){
            listFarmacia.add(farmacia);
            farmacia = new Farmacia();
        }
    }
    
     public String login(){        
        return "";
    }

     
     
     
     
     
     
     
     
    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }

    public List<Paciente> getListPaciente() {
        return listPaciente;
    }

    public void setListPaciente(List<Paciente> listPaciente) {
        this.listPaciente = listPaciente;
    }

    public List<Medico> getListMedico() {
        return listMedico;
    }

    public void setListMedico(List<Medico> listMedico) {
        this.listMedico = listMedico;
    }

    public List<Farmacia> getListFarmacia() {
        return listFarmacia;
    }

    public void setListFarmacia(List<Farmacia> listFarmacia) {
        this.listFarmacia = listFarmacia;
    }
       public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
