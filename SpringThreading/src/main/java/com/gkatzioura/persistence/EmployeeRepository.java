package com.gkatzioura.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by gkatzioura on 4/26/17.
 */
public interface EmployeeRepository extends JpaRepository<Employee,Long>
{
}
