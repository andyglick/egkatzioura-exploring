package com.gkatziours.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.gkatzioura.persistence.Employee;
import com.gkatzioura.persistence.EmployeeRepository;
/**
 * @author glick
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:persistenceContext.xml"})
@EnableTransactionManagement
@EnableJpaRepositories("com.gkatzioura.persistence")
public class EmployeeRespositoryTestIT
{
  @Autowired
  EmployeeRepository employeeRepository;

  @Test
  public void testEmployeeRepository()
  {
    Assertions.assertThat(true).isTrue();

    Employee employee = new Employee();

    employee.setFirstName("Bob");
    employee.setLastname("Dingle");
    employee.setEmail("bobdingle@gmail.com");

    employeeRepository.save(employee);

  }
}
