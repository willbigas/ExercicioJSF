package beans;


import beans.util.Mensagens;
import dao.PessoaDao;
import interfaces.IBaseDao;
import model.Pessoa;
import util.UtilDate;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean
@ViewScoped
public class PessoaBean implements Serializable {

    private Pessoa pessoa;
    private List<Pessoa> pessoas;
    private IBaseDao<Pessoa> pessoaDao;

    @PostConstruct
    public void init() {
        pessoa = new Pessoa();
        pessoaDao = new PessoaDao();
        pessoas = new ArrayList<>();
        atualizar();

    }

    public void salvar() {
        if (pessoa.getId() == null) {
            pessoaDao.salvar(pessoa);
            Mensagens.sucesso("Pessoa cadastrada com sucesso");
        } else {
            pessoaDao.alterar(pessoa);
            Mensagens.sucesso("Pessoa alterada com sucesso!");
        }
        limpar();
        atualizar();
    }

    public void alterar() {
    }

    public void remover() {
        pessoaDao.excluir(pessoa);
        atualizar();
        limpar();
        Mensagens.sucesso("Pessoa excluida com sucesso!");
    }

    public void atualizar() {
        pessoas = pessoaDao.buscarTodos();
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
