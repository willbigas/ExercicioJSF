package beans.converter;

import model.Estado;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Estado.class)
public class EstadoConverter implements Converter {

    //EstadoDao.listarTodos()
//  Instanciar estadoDao no construtor
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        return null;
        // return estadoDaoFindBySigla ou ID
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        return null;
        // Buscar o string do objeto
        // Estado estado = (Estado) o;
        // return estado.getSigla();
    }
}
