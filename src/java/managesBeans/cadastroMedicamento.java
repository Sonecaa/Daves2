/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managesBeans;

import DAOS.MedicamentoDAO;
import classes.Medicamento;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Marcelo
 */
@ManagedBean
@RequestScoped
public class cadastroMedicamento {
    
    private String nome;
    private float valor;
    
    private String result;
    /**
     * Creates a new instance of cadastroMedicamento
     */
    public cadastroMedicamento() {
    }
    
    public void createMedicamento(){
        MedicamentoDAO dao = new MedicamentoDAO();
        Medicamento medicamento = new Medicamento(0, nome, valor);
        dao.save(medicamento);
        result = "Novo medicamento cadastrado: " + nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    
}
