package beans;

import model.Estados;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@ManagedBean
@ViewScoped
public class TesteEnumBean implements Serializable {

    private Estados estados;
    private List<Estados> estadosList;
    private int linguagem;
    private boolean confirmado;
    private List<Integer> linguagens;

    public TesteEnumBean() {
        estadosList = Arrays.asList(Estados.values());
    }


    public void enviar() {
        System.out.println(estados);
        System.out.println(linguagem);
        System.out.println(confirmado);
        System.out.println(linguagens);
    }

    public Estados getEstados() {
        return estados;
    }

    public void setEstados(Estados estados) {
        this.estados = estados;
    }

    public List<Estados> getEstadosList() {
        return estadosList;
    }

    public void setEstadosList(List<Estados> estadosList) {
        this.estadosList = estadosList;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public int getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(int linguagem) {
        this.linguagem = linguagem;
    }

    public List<Integer> getLinguagens() {
        return linguagens;
    }

    public void setLinguagens(List<Integer> linguagens) {
        this.linguagens = linguagens;
    }
}
