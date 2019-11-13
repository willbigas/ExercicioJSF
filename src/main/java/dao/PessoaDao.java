package dao;

import dao.util.JpaUtil;
import dto.PessoasPorProfissaoDTO;
import model.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

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

        return null;
    }

}
