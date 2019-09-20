package beans;


import model.Pessoa;
import util.UtilDate;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean
@ViewScoped
public class PessoaBean {

    public Pessoa pessoa = new Pessoa();
    public List<Pessoa> pessoas = new ArrayList<>();


    public void adicionar() {
        pessoas.add(pessoa);
        limpar();
    }

    public void limpar() {
       pessoa = new Pessoa();
    }

    public String converteData(Date data) {
       return UtilDate.converteDataParaString(data);
    }



    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }


}
