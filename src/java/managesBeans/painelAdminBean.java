/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managesBeans;

import DAOS.FarmaciaDAO;
import DAOS.MedicoDAO;
import DAOS.PacienteDAO;
import DAOS.ReceitaDAO;
import classes.Medico;
import classes.Paciente;
import classes.Receita;
import classes.Receitaxexame;
import classes.Receitaxmedicamento;
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
    
     public String listarMedicamentos(int id){
       String StringList = "";
              
       FarmaciaDAO daoF = new FarmaciaDAO();
       List<Receitaxmedicamento> listamedicamentos = daoF.getAllMedicamentosById(id);
       
        for (int i = 0; i < listamedicamentos.size(); i++) {
          
            StringList += " " + listamedicamentos.get(i).getMedicamento().getNome();
            
        }
        
       return StringList;
    }
     
       public String listarExames(int id){
       String StringList = "";
              
       FarmaciaDAO daoF = new FarmaciaDAO();
       List<Receitaxexame> listaexames = daoF.getAllExamesById(id);
       
        for (int i = 0; i < listaexames.size(); i++) {
          
            StringList += " " + listaexames.get(i).getExame().getNome();
            
        }
        
       return StringList;
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
