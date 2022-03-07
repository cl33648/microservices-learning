package com.microservices.customer;

import com.microservices.clients.fraud.FraudCheckResponse;
import com.microservices.clients.fraud.FraudClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()  //builder from @lombok builder
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        //TODO: check if email is valid
        //TODO: check if email is taken

        customerRepository.saveAndFlush(customer);  //saveAndFlush to keep customerId handy

        //TODO: check if customer is fraudster
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if(fraudCheckResponse.isFraudster()) throw new IllegalStateException("fraudster");

        //TODO: send notificaton
    }
}
