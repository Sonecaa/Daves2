/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managesBeans;

import DAOS.FarmaciaDAO;
import DAOS.MedicoDAO;
import DAOS.PacienteDAO;
import classes.Farmacia;
import classes.Medico;
import classes.Paciente;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Marcelo
 */
@ManagedBean
@RequestScoped
public class cadastroBean {

    private int option;

    private String login;
    private String senha;

    private String result;

    private Paciente pacienteLogado;
    private Medico medicoLogado;
    private Farmacia farmaciaLogado;

    public cadastroBean() {
    }
    

    public String addLogin() {
        if (option == 1) {
            //paciente = new Paciente();
            PacienteDAO dao = new PacienteDAO();
            Paciente paciente = new Paciente(0, login, senha);
            dao.save(paciente);
            result = "Paciente cadastrado";

        }
        if (option == 2) {
            // medico = new Medico();
            MedicoDAO dao = new MedicoDAO();
            Medico medico = new Medico(0, login, senha);
            dao.save(medico);
            result = "Medico cadastrado";

        }
        if (option == 3) {
            // farmacia = new Farmacia();
            FarmaciaDAO dao = new FarmaciaDAO();
            Farmacia farmacia = new Farmacia(0, login, senha);
            dao.save(farmacia);
            result = "Farmacia cadastrado";

        }

        return "";
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Paciente getPacienteLogado() {
        return pacienteLogado;
    }

    public void setPacienteLogado(Paciente pacienteLogado) {
        this.pacienteLogado = pacienteLogado;
    }

    public Medico getMedicoLogado() {
        return medicoLogado;
    }

    public void setMedicoLogado(Medico medicoLogado) {
        this.medicoLogado = medicoLogado;
    }

    public Farmacia getFarmaciaLogado() {
        return farmaciaLogado;
    }

    public void setFarmaciaLogado(Farmacia farmaciaLogado) {
        this.farmaciaLogado = farmaciaLogado;
    }
}
