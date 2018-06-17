/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcelo
 */
@Entity
@Table(catalog = "daves_db", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Receitaxmedicamento.findAll", query = "SELECT r FROM Receitaxmedicamento r"),
    @NamedQuery(name = "Receitaxmedicamento.findByIdreceitaXmedicamento", query = "SELECT r FROM Receitaxmedicamento r WHERE r.idreceitaXmedicamento = :idreceitaXmedicamento")})
public class Receitaxmedicamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idreceitaXmedicamento;
    @JoinColumn(name = "receita", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Receita receita;
    @JoinColumn(name = "medicamento", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Medicamento medicamento;

    public Receitaxmedicamento() {
    }

    public Receitaxmedicamento(Integer idreceitaXmedicamento) {
        this.idreceitaXmedicamento = idreceitaXmedicamento;
    }

    public Integer getIdreceitaXmedicamento() {
        return idreceitaXmedicamento;
    }

    public void setIdreceitaXmedicamento(Integer idreceitaXmedicamento) {
        this.idreceitaXmedicamento = idreceitaXmedicamento;
    }

    public Receita getReceita() {
        return receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreceitaXmedicamento != null ? idreceitaXmedicamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receitaxmedicamento)) {
            return false;
        }
        Receitaxmedicamento other = (Receitaxmedicamento) object;
        if ((this.idreceitaXmedicamento == null && other.idreceitaXmedicamento != null) || (this.idreceitaXmedicamento != null && !this.idreceitaXmedicamento.equals(other.idreceitaXmedicamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "classes.Receitaxmedicamento[ idreceitaXmedicamento=" + idreceitaXmedicamento + " ]";
    }
    
}
