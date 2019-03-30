package com.goyav.model;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customer")
@XmlAccessorType (XmlAccessType.FIELD)
public class CustomerResponse {

    
    private Customer customer = null;
    private List<Customer> customers = null;

    public CustomerResponse() {}
    public CustomerResponse(Customer _customer) {
        this.customer = _customer;
    }
    public CustomerResponse(List<Customer> _customers) {
        this.customers = _customers;
    }


    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer _customer) {
        this.customer = _customer;
    }
}
