
package classes;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Farmacia {
        @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private String senha;
    private List<Medicamento> listMedicamentos;

    public Farmacia(int id, String nome, String senha, List<Medicamento> listMedicamentos) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.listMedicamentos = listMedicamentos;
    }

    public Farmacia() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Medicamento> getListMedicamentos() {
        return listMedicamentos;
    }

    public void setListMedicamentos(List<Medicamento> listMedicamentos) {
        this.listMedicamentos = listMedicamentos;
    }
    
    
}
