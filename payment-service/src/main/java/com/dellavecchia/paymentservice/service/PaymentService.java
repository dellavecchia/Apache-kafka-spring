package com.dellavecchia.paymentservice.service;

import com.dellavecchia.paymentservice.model.Payment;

public interface PaymentService {

    void sendPayment(Payment payment);
}
