package beans;

import dao.ProfissaoDao;
import interfaces.IBaseDao;
import model.Profissao;
import util.Mensagem;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class ProfissaoBean implements Serializable {

    public Profissao profissao;
    private List<Profissao> profissaos;
    private IBaseDao<Profissao> profissaoDao;


    @PostConstruct
    public void init() {
        profissao = new Profissao();
        profissaoDao = new ProfissaoDao();
        profissaos = new ArrayList<>();
        atualizar();

    }

    public void salvar() {
        if (profissao.getId() == null) {
            profissaoDao.salvar(profissao);
            Mensagem.addMensagemInfo("profissaoCadastroSucesso");
        } else {
            profissaoDao.alterar(profissao);
            Mensagem.addMensagemInfo("profissaoCadastroErro");
        }
        limpar();
        atualizar();
    }

    public void alterar() {
    }

    public void remover() {
        profissaoDao.excluir(profissao);
        atualizar();
        limpar();
        Mensagem.addMensagemInfo("profissaoDeletarSucesso");
    }

    public void atualizar() {
        profissaos = profissaoDao.buscarTodos();
    }


    public void limpar() {
        profissao = new Profissao();
    }

    public Profissao getProfissao() {
        return profissao;
    }

    public void setProfissao(Profissao profissao) {
        this.profissao = profissao;
    }

    public List<Profissao> getProfissaos() {
        return profissaos;
    }

    public void setProfissaos(List<Profissao> profissaos) {
        this.profissaos = profissaos;
    }
}
