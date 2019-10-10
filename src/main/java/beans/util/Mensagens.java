package beans.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Mensagens {

    public static void sucesso(String mensagem) {
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, null);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }
}
