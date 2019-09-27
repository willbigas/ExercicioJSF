package dao;

import interfaces.DaoI;
import model.Pessoa;

import javax.persistence.*;
import java.util.List;

public class PessoaDao extends Dao implements DaoI<Pessoa> {

    @Override
    public Pessoa salvar(Pessoa pessoa) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            if (pessoa.getId() == null) {
                entityManager.persist(pessoa);
            } else {
                pessoa = entityManager.merge(pessoa);
            }
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
            return null;
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public boolean excluir(int id) {
        EntityManager entityManager = getEntityManager();
        try {
            entityManager.getTransaction().begin();
            Pessoa pessoa = entityManager.find(Pessoa.class, id);
            entityManager.remove(pessoa);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Pessoa buscarPorId(int id) {
        EntityManager entityManager = getEntityManager();
        Pessoa pessoa = null;
        try {
            return entityManager.find(Pessoa.class, id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Pessoa> listarTodos() {
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createQuery("select p from Pessoa p");
        return (List<Pessoa>) query.getResultList();
    }
}
