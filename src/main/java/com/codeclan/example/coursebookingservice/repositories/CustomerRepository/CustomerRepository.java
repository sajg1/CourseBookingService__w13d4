package com.codeclan.example.coursebookingservice.repositories.CustomerRepository;

import com.codeclan.example.coursebookingservice.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CustomerRepository extends JpaRepository<Customer, Long>, CustomerRepositoryCustom {
}
