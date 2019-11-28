package beans;

import dao.UsuarioDao;
import exception.UsuarioNaoEncontratoException;
import model.Usuario;
import service.LoginService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private String email;
    private String senha;

    private LoginService loginService;

    public LoginBean() {
        loginService = new LoginService();
    }

    public String login() {


        try {
            Usuario usuarioLogado = loginService.verificaLogin(email, senha);

        } catch (UsuarioNaoEncontratoException e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email ou senha inválido", null);
            FacesContext.getCurrentInstance().addMessage(null, message);
            return "/login.xhtml";
        }

        return "/paginas/dashboard.xhtml?faces-redirect=true";
    }

    public String logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        return "/login.xhtml?faces-redirect=true";
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
