package com.awsscreat.exmaple;

import com.awsscreat.exmaple.model.Employee;
import com.awsscreat.exmaple.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Configuration
@EnableCaching
@EnableScheduling
@Slf4j
public class EarMapperProcessor {

    @Autowired
    CacheManager cacheManager;

    @Autowired
    private EmployeeService employeeService;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void updateCache(){
        try {
        log.info("deleting  cache");
        Objects.requireNonNull(cacheManager.getCache("employees")).clear();
        log.info("cache deleted");

        log.info("refreshing cache");

            List<Employee> all = employeeService.getAll();
            log.info("Employee list size = {}",all.size());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        log.info("cache refreshed");
    }
}
