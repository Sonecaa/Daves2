
package classes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Exame {
        @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private Medico medicoQueCadastro;

    public Exame(int id, String nome, Medico medicoQueCadastro) {
        this.id = id;
        this.nome = nome;
        this.medicoQueCadastro = medicoQueCadastro;
    }

    public Exame() {
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

    public Medico getMedicoQueCadastro() {
        return medicoQueCadastro;
    }

    public void setMedicoQueCadastro(Medico medicoQueCadastro) {
        this.medicoQueCadastro = medicoQueCadastro;
    }
    
    
}
