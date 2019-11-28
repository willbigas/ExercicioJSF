package service;

import dao.UsuarioDao;
import exception.UsuarioNaoEncontratoException;
import model.Usuario;
import util.CriptografiaUtil;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class LoginService {

    private UsuarioDao usuarioDao;


    public LoginService() {
        usuarioDao = new UsuarioDao();
    }

    public Usuario verificaLogin(String email, String senha) throws UsuarioNaoEncontratoException {
        String senhaCriptografada = CriptografiaUtil.criptografar(senha);

       Usuario usuarioLogado = usuarioDao.verificaLogin(email, senhaCriptografada);

       if (usuarioLogado == null) {
           throw new UsuarioNaoEncontratoException();
       }

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.setAttribute("usuarioLogado", usuarioLogado);
        return usuarioLogado;
    }
}
