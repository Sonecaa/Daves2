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
    @NamedQuery(name = "Receitaxexame.findAll", query = "SELECT r FROM Receitaxexame r"),
    @NamedQuery(name = "Receitaxexame.findByIdreceitaXexame", query = "SELECT r FROM Receitaxexame r WHERE r.idreceitaXexame = :idreceitaXexame")})
public class Receitaxexame implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer idreceitaXexame;
    @JoinColumn(name = "receita", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Receita receita;
    @JoinColumn(name = "exame", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Exame exame;

    public Receitaxexame() {
    }

    public Receitaxexame(Integer idreceitaXexame) {
        this.idreceitaXexame = idreceitaXexame;
    }

    public Integer getIdreceitaXexame() {
        return idreceitaXexame;
    }

    public void setIdreceitaXexame(Integer idreceitaXexame) {
        this.idreceitaXexame = idreceitaXexame;
    }

    public Receita getReceita() {
        return receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }

    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreceitaXexame != null ? idreceitaXexame.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Receitaxexame)) {
            return false;
        }
        Receitaxexame other = (Receitaxexame) object;
        if ((this.idreceitaXexame == null && other.idreceitaXexame != null) || (this.idreceitaXexame != null && !this.idreceitaXexame.equals(other.idreceitaXexame))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "classes.Receitaxexame[ idreceitaXexame=" + idreceitaXexame + " ]";
    }
    
}
