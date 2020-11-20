package com.mehmetozanguven.springaopexample.repository;

public interface CustomerRepository {
    void findCustomerById(Long id);

    void trickyMethod();

    void indirectCallOfTrickyMethod();
}
