package dao;

import entity.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ChatDaoImpl implements ChatDao{

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public void insert(Chat chat) {
        em.persist(chat);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Chat> selectChats() {
        CriteriaQuery<Chat> criteriaQuery = em.getCriteriaBuilder().createQuery(Chat.class);
        @SuppressWarnings("unused")
        Root<Chat> root = criteriaQuery.from(Chat.class);
        return em.createQuery(criteriaQuery).getResultList();
    }

}
