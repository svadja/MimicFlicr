package ua.sasa.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CommonDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveOrUpdate(Object object) {
        sessionFactory.getCurrentSession().saveOrUpdate(object);
    }

    public Object getById(String clazzString, final Serializable id) {
        Session session = sessionFactory.getCurrentSession();
        Object result = session.get(clazzString, id);
        return result;
    }

    public List getAll(String clazzString) {
        Session session = sessionFactory.getCurrentSession();
        if (clazzString != null) {
            return session.createCriteria(clazzString).list();
        } else {
            return null;
        }
    }

    public void delete(Object object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    public void deleteById(String clazzString, final Serializable id) {
        Session session = sessionFactory.getCurrentSession();
        Object persistentInstance = session.load(clazzString, id);
        if (persistentInstance != null) {
            session.delete(persistentInstance);
        }
    }

}
