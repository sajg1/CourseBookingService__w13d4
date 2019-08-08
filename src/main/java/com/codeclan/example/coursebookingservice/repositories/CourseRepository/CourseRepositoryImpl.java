package com.codeclan.example.coursebookingservice.repositories.CourseRepository;

import com.codeclan.example.coursebookingservice.models.Course;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class CourseRepositoryImpl implements CourseRepositoryCustom{

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Course> getAllCoursesForCustomer(Long customerId){
        List<Course> results = null;

        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Course.class);
            cr.createAlias("bookings", "bookingsAlias");
            cr.createAlias("bookingsAlias.customer", "customerAlias");
            cr.add(Restrictions.eq("customerAlias.id", customerId));
            results = cr.list();
        } catch(HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}
