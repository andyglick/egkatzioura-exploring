package com.gkatzioura;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gkatzioura.service.AsynchronousService;

import javax.inject.Inject;

/**
 * Created by gkatzioura on 4/26/17.
 */
@Component
public class Scheduler {

    @Inject
    private AsynchronousService checkAsyncService;

    @Scheduled(fixedDelay = 10000)
    public void checkTheScedule() {
        checkAsyncService.printEmployees();
    }

}
