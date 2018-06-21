/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managesBeans;

import DAOS.MedicoDAO;
import DAOS.PacienteDAO;
import DAOS.ReceitaDAO;
import classes.Medico;
import classes.Paciente;
import classes.Receita;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Marcelo
 */
@ManagedBean
@ViewScoped 
public class painelAdminBean {

    List<Receita> receitas;
    
    public painelAdminBean() {
        ReceitaDAO daoR = new ReceitaDAO();
        receitas = daoR.getAll();
    }
    
    public String cancelarReceita(int id){
         ReceitaDAO daoR = new ReceitaDAO();
       Receita receita = daoR.findById(id);
       receita.setCancelada(1);
       daoR.save(receita);
       receitas = daoR.getAll();
       return "";
    }
    
    public Paciente pacienteById(int id){
        PacienteDAO daoP = new PacienteDAO();
       Paciente paciente = daoP.findById(id);
       return paciente;
    }
     public Medico medicoById(int id){
        MedicoDAO daoM = new MedicoDAO();
       Medico medico = daoM.findById(id);
       return medico;
    }

    public List<Receita> getReceitas() {
        return receitas;
    }

    public void setReceitas(List<Receita> receitas) {
        this.receitas = receitas;
    }
    
}
