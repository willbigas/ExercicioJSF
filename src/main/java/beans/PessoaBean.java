package beans;


import dao.PessoaDao;
import dao.ProfissaoDao;
import interfaces.IBaseDao;
import model.Pessoa;
import model.Profissao;
import util.Mensagem;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class PessoaBean implements Serializable {

    private Pessoa pessoa;
    private List<Pessoa> pessoas;
    private List<Profissao> profissaos;
    private IBaseDao<Pessoa> pessoaDao;
    private IBaseDao<Profissao> profissaoDao;

    @PostConstruct
    public void init() {
        pessoa = new Pessoa();
        pessoaDao = new PessoaDao();
        profissaoDao = new ProfissaoDao();
        pessoas = new ArrayList<>();
        profissaos = new ArrayList<>();
        atualizar();

    }

    public void salvar() {
        if (pessoa.getId() == null) {
            pessoaDao.salvar(pessoa);
            Mensagem.addMensagemInfo("pessoaCadastroSucesso");
        } else {
            pessoaDao.alterar(pessoa);
            Mensagem.addMensagemError("pessoaCadastroErro");
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
        Mensagem.addMensagemInfo("pessoaExclusaoSucesso");
    }

    public void atualizar() {
        pessoas = pessoaDao.buscarTodos();
        profissaos = profissaoDao.buscarTodos();
    }


    public void limpar() {
        pessoa = new Pessoa();
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

    public List<Profissao> getProfissaos() {
        return profissaos;
    }

    public void setProfissaos(List<Profissao> profissaos) {
        this.profissaos = profissaos;
    }
}
