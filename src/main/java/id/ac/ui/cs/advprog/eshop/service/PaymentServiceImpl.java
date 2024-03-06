package id.ac.ui.cs.advprog.eshop.service;

import java.util.List;
import java.util.Map;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;

public class PaymentServiceImpl implements PaymentService {

    @Override
    public Payment addPayment(Order order, String method, Map<String, String> data) {
        throw new UnsupportedOperationException("Unimplemented method 'addPayment'");
    }

    @Override
    public List<Payment> getAllPayments() {
        throw new UnsupportedOperationException("Unimplemented method 'getAllPayments'");
    }

    @Override
    public Payment getPaymentById(String id) {
        throw new UnsupportedOperationException("Unimplemented method 'getPaymentById'");
    }

    @Override
    public Payment setStatus(String id, String status) {
        throw new UnsupportedOperationException("Unimplemented method 'setStatus'");
    }

}