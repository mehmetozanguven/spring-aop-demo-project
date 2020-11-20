package com.mehmetozanguven.springaopexample.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerRepositoryImpl.class);

    @Override
    public void findCustomerById(Long id) {
        // return customer by id
    }

    @Override
    public void trickyMethod() {
        LOGGER.info("Tricky method called");
    }

    @Override
    public void indirectCallOfTrickyMethod() {
        LOGGER.info("-------");
        LOGGER.info("indirectCallOfTrickyMethod will call the trickyMethod");
        LOGGER.info("Aspect will not work in that case.");
        LOGGER.info("-------");
        trickyMethod();
    }
}
