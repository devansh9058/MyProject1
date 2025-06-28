package com.example.RegisterLogin.Repo;

import com.example.RegisterLogin.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
@EnableJpaRepositories
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Employee findByEmail(String email);

    Employee findByEmailAndPassword(String email, String password1);

    boolean existsByEmail(String email);
}
