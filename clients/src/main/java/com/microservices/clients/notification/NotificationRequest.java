package com.microservices.clients.notification;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequest {
    public Integer toCustomerId;
    public String toCustomerEmail;
    public String message;
}
