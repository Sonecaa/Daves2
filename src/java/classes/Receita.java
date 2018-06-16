/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Marcelo
 */
@Entity
public class Receita {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int registro;
    private Date date;
    private List<Medicamento> listMedicamento;
    private String dosagem;
    private String ViaAdmnistracao;
    private String Frequencia;
    private String HorarioAdministracao;
    private List<Exame> listExame;
    private String Dietas;
    private String Nutricao;
    private Medico medico;
    private Paciente paciente;
    private Boolean foivendida;
    private Farmacia farmacia;
    private Boolean cancelada;

    public Receita(int registro, Date date, List<Medicamento> listMedicamento, String dosagem, String ViaAdmnistracao, String Frequencia, String HorarioAdministracao, List<Exame> listExame, String Dietas, String Nutricao, Medico medico, Paciente paciente, Boolean foivendida, Farmacia farmacia, Boolean cancelada) {
        this.registro = registro;
        this.date = date;
        this.listMedicamento = listMedicamento;
        this.dosagem = dosagem;
        this.ViaAdmnistracao = ViaAdmnistracao;
        this.Frequencia = Frequencia;
        this.HorarioAdministracao = HorarioAdministracao;
        this.listExame = listExame;
        this.Dietas = Dietas;
        this.Nutricao = Nutricao;
        this.medico = medico;
        this.paciente = paciente;
        this.foivendida = foivendida;
        this.farmacia = farmacia;
        this.cancelada = cancelada;
    }

    public Receita() {
    }

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Medicamento> getListMedicamento() {
        return listMedicamento;
    }

    public void setListMedicamento(List<Medicamento> listMedicamento) {
        this.listMedicamento = listMedicamento;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public String getViaAdmnistracao() {
        return ViaAdmnistracao;
    }

    public void setViaAdmnistracao(String ViaAdmnistracao) {
        this.ViaAdmnistracao = ViaAdmnistracao;
    }

    public String getFrequencia() {
        return Frequencia;
    }

    public void setFrequencia(String Frequencia) {
        this.Frequencia = Frequencia;
    }

    public String getHorarioAdministracao() {
        return HorarioAdministracao;
    }

    public void setHorarioAdministracao(String HorarioAdministracao) {
        this.HorarioAdministracao = HorarioAdministracao;
    }

    public List<Exame> getListExame() {
        return listExame;
    }

    public void setListExame(List<Exame> listExame) {
        this.listExame = listExame;
    }

    public String getDietas() {
        return Dietas;
    }

    public void setDietas(String Dietas) {
        this.Dietas = Dietas;
    }

    public String getNutricao() {
        return Nutricao;
    }

    public void setNutricao(String Nutricao) {
        this.Nutricao = Nutricao;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Boolean getFoivendida() {
        return foivendida;
    }

    public void setFoivendida(Boolean foivendida) {
        this.foivendida = foivendida;
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }

    public Boolean getCancelada() {
        return cancelada;
    }

    public void setCancelada(Boolean cancelada) {
        this.cancelada = cancelada;
    }
    
    
}
