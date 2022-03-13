package com.microservices.clients.notification;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NotificationRequest {
    public Integer toCustomerId;
    public String toCustomerEmail;
    public String message;
}
