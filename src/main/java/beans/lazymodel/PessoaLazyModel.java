package beans.lazymodel;

import dao.PessoaDao;
import dao.filter.PessoaFilter;
import model.Pessoa;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import java.util.List;
import java.util.Map;

public class PessoaLazyModel extends LazyDataModel<Pessoa> {

    private PessoaFilter filtro;
    private PessoaDao pessoaDao;


    public PessoaLazyModel(PessoaDao pessoaDao) {
        this.pessoaDao = pessoaDao;
        filtro = new PessoaFilter();
    }

    @Override
    public List<Pessoa> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {

        filtro.setPrimeiroRegistro(first);
        filtro.setQuantidadeRegistros(pageSize);
        filtro.setPropriedadeOrdenacao(sortField);
        filtro.setAscendente(SortOrder.ASCENDING.equals(sortOrder));
        filtro.setFiltros(filters);
        setRowCount(pessoaDao.total());

        return pessoaDao.buscar(filtro);

    }
}
