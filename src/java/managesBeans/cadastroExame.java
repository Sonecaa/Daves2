
package managesBeans;

import DAOS.ExameDAO;
import classes.Exame;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class cadastroExame {
    
    private String nome;
    private int medicoResponsavel;
    
    private String result;
    public cadastroExame() {
    }
    
    public void createExame(){
        ExameDAO dao = new ExameDAO();
        Exame exame = new Exame(0, nome, medicoResponsavel);
        dao.save(exame);
        result = "Novo exame cadastrado: " + nome;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMedicoResponsavel() {
        return medicoResponsavel;
    }

    public void setMedicoResponsavel(int medicoResponsavel) {
        this.medicoResponsavel = medicoResponsavel;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    
}
