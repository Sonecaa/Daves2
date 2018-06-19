/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managesBeans;

import DAOS.ExameDAO;
import DAOS.MedicamentoDAO;
import DAOS.MedicoDAO;
import DAOS.PacienteDAO;
import DAOS.ReceitaDAO;
import classes.Exame;
import classes.Medicamento;
import classes.Medico;
import classes.Paciente;
import classes.Receita;
import classes.Receitaxexame;
import classes.Receitaxmedicamento;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Marcelo
 */
@ManagedBean
@RequestScoped
public class cadastroReceita {

    private List<Medico> medicos;
    private List<Paciente> pacientes;
    private List<Medicamento> medicamentos;
    private List<Exame> exames;

    //cad        
    private List<String> listaMedicamento;
    private String dosagem;
    private String viaAdministracao;
    private String frequencia;
    private String horarioAdministracao;
    private String dietas;
    private String nutricao;
    private List<String> listaExames;
    private int medicoResponsavel;
    private int pacienteReceitado;
    private int foivendida = 0;

   
    private String result;
    public cadastroReceita() {
        medicos = listarComboMedico();
        pacientes = listarComboPaciente();
        medicamentos = listarComboMedicamento();
        exames = listarComboExame();
    }

    public void createReceita() {
        try {

            ReceitaDAO dao = new ReceitaDAO();
            java.util.Date date = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());

            Receita receita = new Receita(0, sqlDate, medicoResponsavel, pacienteReceitado, 0);
            receita.setDosagem(dosagem);
            receita.setViaAdministracao(viaAdministracao);
            receita.setFrequencia(frequencia);
            receita.setHorarioAdministracao(horarioAdministracao);
            receita.setDietas(dietas);
            receita.setNutricao(nutricao);
            dao.save(receita);

            for (int i = 0; i < listaMedicamento.size(); i++) {
                 Receitaxmedicamento rxm = new Receitaxmedicamento(); 
                 MedicamentoDAO mDao  = new MedicamentoDAO();
                 Medicamento m = mDao.findByName(listaMedicamento.get(i));
                rxm.setMedicamento(m);
                rxm.setReceita(receita);
                dao.saveMedicamentos(rxm);
            }
             for (int i = 0; i < listaExames.size(); i++) {
                 Receitaxexame rxe = new Receitaxexame(); 
                 ExameDAO eDao  = new ExameDAO();
                 Exame e = eDao.findByName(listaExames.get(i));
                rxe.setExame(e);
                rxe.setReceita(receita);
                dao.saveExames(rxe);
            }
             result =  "NOVA RECEITA DE :"+ medicoResponsavel +"CADASTRADA PARA :" + pacienteReceitado;
        } catch (Exception e) {
                result = e.getMessage() + " | " + listaMedicamento.get(1);
        }

    }

    public List<Medico> listarComboMedico() {
        MedicoDAO dao = new MedicoDAO();
        return dao.getAll();
    }

    public List<Paciente> listarComboPaciente() {
        PacienteDAO dao = new PacienteDAO();
        return dao.getAll();
    }

    public List<Medicamento> listarComboMedicamento() {
        MedicamentoDAO dao = new MedicamentoDAO();
        return dao.getAll();
    }
    public List<Exame> listarComboExame() {
        ExameDAO dao = new ExameDAO();
        return dao.getAll();
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }

    public List<String> getListaMedicamento() {
        return listaMedicamento;
    }

    public void setListaMedicamento(List<String> listaMedicamento) {
        this.listaMedicamento = listaMedicamento;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public String getViaAdministracao() {
        return viaAdministracao;
    }

    public void setViaAdministracao(String viaAdministracao) {
        this.viaAdministracao = viaAdministracao;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    public String getHorarioAdministracao() {
        return horarioAdministracao;
    }

    public void setHorarioAdministracao(String horarioAdministracao) {
        this.horarioAdministracao = horarioAdministracao;
    }

    public String getDietas() {
        return dietas;
    }

    public void setDietas(String dietas) {
        this.dietas = dietas;
    }

    public String getNutricao() {
        return nutricao;
    }

    public void setNutricao(String nutricao) {
        this.nutricao = nutricao;
    }

    public int getMedicoResponsavel() {
        return medicoResponsavel;
    }

    public void setMedicoResponsavel(int medicoResponsavel) {
        this.medicoResponsavel = medicoResponsavel;
    }

    public int getPacienteReceitado() {
        return pacienteReceitado;
    }

    public void setPacienteReceitado(int pacienteReceitado) {
        this.pacienteReceitado = pacienteReceitado;
    }

    public int getFoivendida() {
        return foivendida;
    }

    public void setFoivendida(int foivendida) {
        this.foivendida = foivendida;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<String> getListaExames() {
        return listaExames;
    }

    public void setListaExames(List<String> listaExames) {
        this.listaExames = listaExames;
    }

    public List<Exame> getExames() {
        return exames;
    }

    public void setExames(List<Exame> exames) {
        this.exames = exames;
    }
    
    
}
