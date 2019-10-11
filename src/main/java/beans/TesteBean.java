package beans;

import model.Estado;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@ManagedBean
@ViewScoped
public class TesteBean implements Serializable {

    private Estado estado;

    private List<Estado> estados;


    public TesteBean() {
        estados = Arrays.asList(
                new Estado("SC", "Santa catarina"),
                new Estado("PR", "Paraná"),
                new Estado("RS", "Rio grande do sul"));
    }

    public void enviar() {
        System.out.println(estado);

    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }
}

