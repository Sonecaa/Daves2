/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcelo
 */
@Entity
@Table(catalog = "daves_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Receita.findAll", query = "SELECT r FROM Receita r"),
    @NamedQuery(name = "Receita.findById", query = "SELECT r FROM Receita r WHERE r.id = :id"),
    @NamedQuery(name = "Receita.findByDataGerado", query = "SELECT r FROM Receita r WHERE r.dataGerado = :dataGerado"),
    @NamedQuery(name = "Receita.findByDosagem", query = "SELECT r FROM Receita r WHERE r.dosagem = :dosagem"),
    @NamedQuery(name = "Receita.findByViaAdministracao", query = "SELECT r FROM Receita r WHERE r.viaAdministracao = :viaAdministracao"),
    @NamedQuery(name = "Receita.findByFrequencia", query = "SELECT r FROM Receita r WHERE r.frequencia = :frequencia"),
    @NamedQuery(name = "Receita.findByHorarioAdministracao", query = "SELECT r FROM Receita r WHERE r.horarioAdministracao = :horarioAdministracao"),
    @NamedQuery(name = "Receita.findByDietas", query = "SELECT r FROM Receita r WHERE r.dietas = :dietas"),
    @NamedQuery(name = "Receita.findByNutricao", query = "SELECT r FROM Receita r WHERE r.nutricao = :nutricao"),
    @NamedQuery(name = "Receita.findByMedicoResponsavel", query = "SELECT r FROM Receita r WHERE r.medicoResponsavel = :medicoResponsavel"),
    @NamedQuery(name = "Receita.findByPacienteResponsavel", query = "SELECT r FROM Receita r WHERE r.pacienteResponsavel = :pacienteResponsavel"),
    @NamedQuery(name = "Receita.findByFoivendida", query = "SELECT r FROM Receita r WHERE r.foivendida = :foivendida"),
    @NamedQuery(name = "Receita.findByFarmaciaQueVendeu", query = "SELECT r FROM Receita r WHERE r.farmaciaQueVendeu = :farmaciaQueVendeu"),
    @NamedQuery(name = "Receita.findByCancelada", query = "SELECT r FROM Receita r WHERE r.cancelada = :cancelada")})
public class Receita implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataGerado;
    @Column(length = 45)
    private String dosagem;
    @Column(length = 45)
    private String viaAdministracao;
    @Column(length = 45)
    private String frequencia;
    @Column(length = 45)
    private String horarioAdministracao;
    @Column(length = 45)
    private String dietas;
    @Column(length = 45)
    private String nutricao;
    @Basic(optional = false)
    @Column(nullable = false)
    private int medicoResponsavel;
    @Basic(optional = false)
    @Column(nullable = false)
    private int pacienteResponsavel;
    @Basic(optional = false)
    @Column(nullable = false)
    private int foivendida;
    private Integer farmaciaQueVendeu;
    private Integer cancelada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receita")
    private List<Receitaxexame> receitaxexameList;
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Farmacia farmacia;
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Medico medico;
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Paciente paciente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receita")
    private List<Receitaxmedicamento> receitaxmedicamentoList;

    public Receita() {
    }

    public Receita(Integer id) {
        this.id = id;
    }

    public Receita(Integer id, Date dataGerado, int medicoResponsavel, int pacienteResponsavel, int foivendida) {
        this.id = id;
        this.dataGerado = dataGerado;
        this.medicoResponsavel = medicoResponsavel;
        this.pacienteResponsavel = pacienteResponsavel;
        this.foivendida = foivendida;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataGerado() {
        return dataGerado;
    }

    public void setDataGerado(Date dataGerado) {
        this.dataGerado = dataGerado;
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

    public int getPacienteResponsavel() {
        return pacienteResponsavel;
    }

    public void setPacienteResponsavel(int pacienteResponsavel) {
        this.pacienteResponsavel = pacienteResponsavel;
    }

    public int getFoivendida() {
        return foivendida;
    }

    public void setFoivendida(int foivendida) {
        this.foivendida = foivendida;
    }

    public Integer getFarmaciaQueVendeu() {
        return farmaciaQueVendeu;
    }

    public void setFarmaciaQueVendeu(Integer farmaciaQueVendeu) {
        this.farmaciaQueVendeu = farmaciaQueVendeu;
    }

    public Integer getCancelada() {
        return cancelada;
    }

    public void setCancelada(Integer cancelada) {
        this.cancelada = cancelada;
    }

    @XmlTransient
    public List<Receitaxexame> getReceitaxexameList() {
        return receitaxexameList;
    }

    public void setReceitaxexameList(List<Receitaxexame> receitaxexameList) {
        this.receitaxexameList = receitaxexameList;
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
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

    @XmlTransient
    public List<Receitaxmedicamento> getReceitaxmedicamentoList() {
        return receitaxmedicamentoList;
    }

    public void setReceitaxmedicamentoList(List<Receitaxmedicamento> receitaxmedicamentoList) {
        this.receitaxmedicamentoList = receitaxmedicamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receita)) {
            return false;
        }
        Receita other = (Receita) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "classes.Receita[ id=" + id + " ]";
    }
    
}
