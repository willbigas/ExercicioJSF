package beans;

import dao.UsuarioDao;
import model.Usuario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private String email;
    private String senha;

    private UsuarioDao usuarioDao;

    public LoginBean() {
        usuarioDao = new UsuarioDao();
    }

    public String login() {
        Usuario usuarioLogado = usuarioDao.verificaLogin(email, senha);

        if (usuarioLogado == null) {
            System.out.println("Não logado");
        } else {
            System.out.println("Logado");
        }

        return "";
    }

    public String logout() {
        return "";
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
