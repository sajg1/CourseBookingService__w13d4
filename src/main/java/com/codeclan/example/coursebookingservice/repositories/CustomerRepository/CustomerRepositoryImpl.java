package com.codeclan.example.coursebookingservice.repositories.CustomerRepository;

import com.codeclan.example.coursebookingservice.models.Course;
import com.codeclan.example.coursebookingservice.models.Customer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Customer> getAllCustomersForCourse(Long courseId) {
        List<Customer> results = null;

        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria cr = session.createCriteria(Customer.class);
            cr.createAlias("bookings", "bookingsAlias");
            cr.createAlias("bookingsAlias.course", "courseAlias");
            cr.add(Restrictions.eq("courseAlias.id", courseId));
            results = cr.list();
        } catch(HibernateException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

}
