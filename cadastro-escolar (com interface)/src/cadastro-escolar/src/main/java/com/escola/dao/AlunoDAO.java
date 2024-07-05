package com.escola.dao;

import com.escola.model.Aluno;
import com.escola.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class AlunoDAO {
    public void inserir(Aluno aluno) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(aluno);
        em.getTransaction().commit();
        em.close();
    }

    public List<Aluno> listar() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Aluno> query = em.createQuery("SELECT a FROM Aluno a", Aluno.class);
        List<Aluno> alunos = query.getResultList();
        em.close();
        return alunos;
    }

    public List<Aluno> listarPorNomeInicial(String inicial) {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Aluno> query = em.createQuery("SELECT a FROM Aluno a WHERE a.nome LIKE :inicial", Aluno.class);
        query.setParameter("inicial", inicial + "%");
        List<Aluno> alunos = query.getResultList();
        em.close();
        return alunos;
    }

    public void alterar(Aluno aluno) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(aluno);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Aluno aluno = em.find(Aluno.class, id);
        if (aluno != null) {
            em.getTransaction().begin();
            em.remove(aluno);
            em.getTransaction().commit();
        }
        em.close();
    }
}
