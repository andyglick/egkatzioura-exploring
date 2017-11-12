package com.gkatzioura.service;

import org.springframework.context.ApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gkatzioura.MyThread;
import com.gkatzioura.persistence.Employee;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.inject.Inject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by gkatzioura on 4/26/17.
 */
@Service
public class AsynchronousService {

    @Inject
    private TaskExecutor taskExecutor;

    @Inject
    private ApplicationContext applicationContext;

    @PersistenceContext
    private EntityManager entityManager;

    @Async
    @Transactional
    public void printEmployees() {

        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e").getResultList();
        employees.stream().forEach(e->System.out.println(e.getEmail()));
    }

    @Async("specificTaskExecutor")
    @Transactional
    public CompletableFuture<List<Employee>> fetchEmployess() {
        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e").getResultList();
        return CompletableFuture.completedFuture(employees);
    }


    public void executeAsynchronously() {

        MyThread myThread = applicationContext.getBean(MyThread.class);
        taskExecutor.execute(myThread);
    }

}
