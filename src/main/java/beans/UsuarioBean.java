package beans;

import dao.UsuarioDao;
import interfaces.IBaseDao;
import model.Usuario;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {

    Usuario usuario;
    List<Usuario> usuariosDoBanco;
    private IBaseDao<Usuario> usuarioDao;

    @PostConstruct
    public void init() {
        usuario = new Usuario();
        usuarioDao = new UsuarioDao();
        usuariosDoBanco = usuarioDao.buscarTodos();
    }

    public void atualizar() {
        usuariosDoBanco = usuarioDao.buscarTodos();
    }

    public void logar() {
        for (int i = 0; i < usuariosDoBanco.size(); i++) {
            Usuario umUsuarioDoBanco = usuariosDoBanco.get(i);
            if (umUsuarioDoBanco.getLogin().equals(usuario.getLogin()) && umUsuarioDoBanco.getSenha().equals(usuario.getSenha())) {

            }
        }


    }


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
