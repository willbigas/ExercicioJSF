package beans.converter;

import dao.ProfissaoDao;
import interfaces.IBaseDao;
import model.Profissao;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Profissao.class)
public class ProfissaoConverter implements Converter {

    private IBaseDao<Profissao> profissaoDao;

    public ProfissaoConverter() {
        profissaoDao = new ProfissaoDao();
    }

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (profissaoDao.buscarPorid(Long.valueOf(s)) == null) {
            return null;
        } else {
            Profissao profissao = (Profissao) profissaoDao.buscarPorid(Long.valueOf(s));
            return profissao;
        }

    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        Profissao profissao = (Profissao) o;
        profissao = profissaoDao.buscarPorid(profissao.getId());
        if (profissao == null) {
            return null;
        } else {
            return profissao.getId().toString();
        }
    }
}
