package com.mehmetozanguven.springaopexample.service;

public interface CustomerService {
    void findCustomerById(Long id);

    void callTrickyMethodDirectly();

    void callingTrickyMethodInDirectly();
}
