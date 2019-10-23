package util;

import javax.faces.context.FacesContext;
import javax.rmi.CORBA.Util;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pagina {

    public static void redirecionarPagina(String pagina) {
        FacesContext context = FacesContext.getCurrentInstance();
        String url = context.getExternalContext().getRequestContextPath();
        try {
            context.getExternalContext().redirect(url + "/" + pagina);
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
