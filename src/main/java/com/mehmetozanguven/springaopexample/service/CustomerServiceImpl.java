package com.mehmetozanguven.springaopexample.service;

import com.mehmetozanguven.springaopexample.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void findCustomerById(Long id) {
        customerRepository.findCustomerById(id);
    }

    @Override
    public void callTrickyMethodDirectly() {
        customerRepository.trickyMethod();
    }

    @Override
    public void callingTrickyMethodInDirectly() {
        customerRepository.indirectCallOfTrickyMethod();
    }
}
