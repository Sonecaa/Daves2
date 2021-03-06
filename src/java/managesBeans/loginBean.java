/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managesBeans;

import DAOS.FarmaciaDAO;
import DAOS.MedicoDAO;
import DAOS.PacienteDAO;
import classes.Farmacia;
import classes.Medico;
import classes.Paciente;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Marcelo
 */
@ManagedBean
@SessionScoped
public class loginBean {

    private int option;
    
    private String login;
    private String senha;
    
    private String result;
    
    private Paciente pacienteLogado;
    private Medico medicoLogado;
    private Farmacia farmaciaLogado;
    
     public loginBean() {
        
    }
     
    
     public String login(){        
          if(option == 1){
            PacienteDAO dao = new PacienteDAO();
            if(dao.checkaLogin(login, senha) != null){
                pacienteLogado = dao.checkaLogin(login, senha);
                return "Paciente/panelPaciente.xhtml";               
            }else{
                result = "Usuario ou senhas inexistente!";
            }
            
        }
        if(option == 2){       
            MedicoDAO dao = new MedicoDAO();
            if(dao.checkaLogin(login, senha) != null){
                medicoLogado = dao.checkaLogin(login, senha);
              return "Medico/panelMedico.xhtml";        
            }else{
                result = "Usuario ou senhas inexistente!";
            }

        }
        if(option == 3){      
            FarmaciaDAO dao = new FarmaciaDAO();
             if(dao.checkaLogin(login, senha) != null){
                farmaciaLogado = dao.checkaLogin(login, senha);
                return "Farmacia/panelFarmacia.xhtml";       
            }else{
                result = "Usuario ou senhas inexistente!";
            }

        }
        
        result = "Erro";
        return "";
    }
    

         
     
     
    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Paciente getPacienteLogado() {
        return pacienteLogado;
    }

    public void setPacienteLogado(Paciente pacienteLogado) {
        this.pacienteLogado = pacienteLogado;
    }

    public Medico getMedicoLogado() {
        return medicoLogado;
    }

    public void setMedicoLogado(Medico medicoLogado) {
        this.medicoLogado = medicoLogado;
    }

    public Farmacia getFarmaciaLogado() {
        return farmaciaLogado;
    }

    public void setFarmaciaLogado(Farmacia farmaciaLogado) {
        this.farmaciaLogado = farmaciaLogado;
    }
   
    
}
