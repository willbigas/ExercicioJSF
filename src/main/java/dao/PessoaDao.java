package dao;

import dao.filter.PessoaFilter;
import dao.util.JpaUtil;
import dto.PessoasPorProfissaoDTO;
import model.Pessoa;
import org.primefaces.model.SortOrder;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

public class PessoaDao extends BaseDao<Pessoa> {

    public List<PessoasPorProfissaoDTO> buscaPessoasPorProfissao() {
        EntityManager manager = JpaUtil.getEntityManager();

        StringBuilder jpqlBuilder = new StringBuilder();
        jpqlBuilder.append(" select new dto.PessoasPorProfissaoDTO( ");
        jpqlBuilder.append("   prof.descricao,");
        jpqlBuilder.append("   count(pe)");
        jpqlBuilder.append("   ) ");
        jpqlBuilder.append("   from Pessoa pe");
        jpqlBuilder.append("   right join pe.profissao prof");
        jpqlBuilder.append("   group by prof.descricao");


        TypedQuery<PessoasPorProfissaoDTO> query = manager.createQuery(jpqlBuilder.toString(), PessoasPorProfissaoDTO.class);
        List<PessoasPorProfissaoDTO> resultado = query.getResultList();
        manager.close();

        return resultado;
    }

    public List<Pessoa> buscar(PessoaFilter filtro) {

        EntityManager manager = JpaUtil.getEntityManager();

        try {

            StringBuilder jpqlBuilder = new StringBuilder();
            jpqlBuilder.append("select p from Pessoa p ");
            jpqlBuilder.append("where 1=1 ");


            for (Map.Entry<String, Object> entry : filtro.getFiltros().entrySet()) {
                jpqlBuilder.append(" and p.").append(entry.getKey()).append(" like :").append(entry.getKey());
            }

            if (filtro.getPropriedadeOrdenacao() != null) {
                jpqlBuilder.append("order by ").append(filtro.getPropriedadeOrdenacao());

                if (!filtro.isAscendente()) {
                    jpqlBuilder.append(" desc");
                }
            }

            TypedQuery<Pessoa> query = manager.createQuery(jpqlBuilder.toString(), Pessoa.class);

            for (Map.Entry<String, Object> entry : filtro.getFiltros().entrySet()) {
              query.setParameter(entry.getKey() , "%"+entry.getValue()+"%");
            }

            query.setFirstResult(filtro.getPrimeiroRegistro());
            query.setMaxResults(filtro.getQuantidadeRegistros());

            return query.getResultList();
        } finally {
            manager.close();
        }
    }

    public int total() {
        EntityManager manager = JpaUtil.getEntityManager();

        try {
            String jpql = "select count(p) from Pessoa p";
            TypedQuery<Long> query = manager.createQuery(jpql.toString(), Long.class);
            return query.getSingleResult().intValue();
        } finally {
            manager.close();
        }

    }

}
