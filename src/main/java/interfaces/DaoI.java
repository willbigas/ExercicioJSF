package interfaces;

import javax.persistence.EntityManager;
import java.util.List;

public interface DaoI<T> {

    public T salvar(T obj);

    public boolean excluir(int id);

    public T buscarPorId(int id);

    public List<T> listarTodos();

}
