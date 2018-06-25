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
import classes.Farmacia;
import classes.Medico;
import classes.Paciente;
import classes.Receita;
import classes.Receitaxexame;
import classes.Receitaxmedicamento;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Marcelo
 */
@ManagedBean
@ViewScoped
public class painelFarmacia {

    /**
     * Creates a new instance of painelFarmacia
     */
    List<Paciente> pacientes;

    List<Receita> receitas;

    int id;

    String result;

    public painelFarmacia() {
        PacienteDAO daoP = new PacienteDAO();
        pacientes = daoP.getAll();

        listaReceitasByPaciente();
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

    public String venderReceita(int id, int idFarmacia) {
        ReceitaDAO daoR = new ReceitaDAO();
        Receita receita = daoR.findById(id);
        //seta q foi vendida
        receita.setFoivendida(1);
        //farmacia que foi vendida
        FarmaciaDAO daoF = new FarmaciaDAO();
        Farmacia farmacia = daoF.findById(idFarmacia);
        receita.setFarmacia(farmacia);
        //save receita
        daoR.save(receita);
        //list receitas do paciente
        receitas = daoR.getAll();
        return "";
    }

    public String listaReceitasByPaciente() {
        try {
            Paciente paciente = pacienteById(id);
            ReceitaDAO daoR = new ReceitaDAO();
            receitas = daoR.getReceitasByPaciente(paciente.getId());
            //return "";
        } catch (Exception e) {
            result = e.getMessage();
        }
        return "";
    }

    public Paciente pacienteById(int id) {
        PacienteDAO daoP = new PacienteDAO();
        Paciente paciente = daoP.findById(id);
        return paciente;
    }

    public Medico medicoById(int id) {
        MedicoDAO daoM = new MedicoDAO();
        Medico medico = daoM.findById(id);
        return medico;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public List<Receita> getReceitas() {
        return receitas;
    }

    public void setReceitas(List<Receita> receitas) {
        this.receitas = receitas;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
