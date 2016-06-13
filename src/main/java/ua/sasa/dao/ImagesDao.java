
package ua.sasa.dao;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.sasa.domain.Image;

/**
 *
 * @author Vadim
 */
@Repository
@Transactional
public class ImagesDao {

    @Autowired
    private SessionFactory sessionFactory;
    
    public List<Image> getImages(String name, String description, Instant  dateStart, Instant dateEnd){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Image.class.getName());
        if ((name!=null)&&(!name.trim().isEmpty())){
            criteria.add(Restrictions.ilike("name", name, MatchMode.ANYWHERE));
        }
        if((description!=null)&&(!description.trim().isEmpty())){
            criteria.add(Restrictions.ilike("description", description,MatchMode.ANYWHERE));
        }
        if (dateStart!=null){
            criteria.add(Restrictions.ge("dateCreation", dateStart));
        }
        if (dateEnd!=null){
            criteria.add(Restrictions.le("dateCreation", dateEnd));
        }
        return criteria.list(); 
    };

}
