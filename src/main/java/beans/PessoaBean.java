package beans;


import beans.lazymodel.PessoaLazyModel;
import dao.PessoaDao;
import dao.ProfissaoDao;
import interfaces.IBaseDao;
import model.Pessoa;
import model.Profissao;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import util.Mensagem;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ManagedBean
@ViewScoped
public class PessoaBean implements Serializable {

    private Pessoa pessoa;
    private List<Pessoa> pessoasFiltro;
    private List<Profissao> profissaos;
    private PessoaDao pessoaDao;
    private IBaseDao<Profissao> profissaoDao;
    private LazyDataModel<Pessoa> model;

    @PostConstruct
    public void init() {
        pessoa = new Pessoa();
        pessoaDao = new PessoaDao();
        profissaoDao = new ProfissaoDao();
        profissaos = new ArrayList<>();
        atualizar();

    }

    public void salvar() {
        if (pessoa.getId() == null) {
            pessoaDao.salvar(pessoa);
            Mensagem.addMensagemInfo("pessoaCadastroSucesso");
        } else {
            pessoaDao.alterar(pessoa);
            Mensagem.addMensagemInfo("pessoaAlteradoSucesso");
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
        profissaos = profissaoDao.buscarTodos();
        model = new PessoaLazyModel(pessoaDao);
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

    public List<Profissao> getProfissaos() {
        return profissaos;
    }

    public void setProfissaos(List<Profissao> profissaos) {
        this.profissaos = profissaos;
    }

    public List<Pessoa> getPessoasFiltro() {
        return pessoasFiltro;
    }

    public void setPessoasFiltro(List<Pessoa> pessoasFiltro) {
        this.pessoasFiltro = pessoasFiltro;
    }

    public LazyDataModel<Pessoa> getModel() {
        return model;
    }

    public void setModel(LazyDataModel<Pessoa> model) {
        this.model = model;
    }
}
