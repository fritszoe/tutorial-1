package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {
    private Map<String, String> paymentData;
    private Order order;
    private List<Product> products;

    @BeforeEach
    void setup() {
        this.paymentData = new HashMap<>();

        products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);
        products.add(product1);

        Product product2 = new Product();
        product2.setProductId("e2c6238-4a37-4669-83c9-f32db86201055");
        product2.setProductName("Sampo cap Koski");
        product2.setProductQuantity(1);
        products.add(product2);

        order = new Order("13652556-012a-4c07-b546-54eb1396d79b",
                this.products, 1708560000L, "Safira Sudrajat");
    }

    void loadBankTransferPaymentData() {
        paymentData.put("bankname", "Permata");
        paymentData.put("referenceCode", "123456789");
    }

    void loadVoucherPaymentData() {
        paymentData.put("voucherCode", "TUTORIAL1ADPRO2023");
    }

    @Test
    void testCreatePaymentWithNoOrder() {
        loadBankTransferPaymentData();
        assertThrows(IllegalArgumentException.class, () -> {
            new Payment("fr13G8hJ-9a7f-4669-92F2-eaf539291cc0",
                    PaymentMethod.BANK.getValue(), null, paymentData);
        });
        paymentData.clear();
    }

    @Test
    void testCreatePaymentWithNoPaymentMethod() {
        loadBankTransferPaymentData();
        assertThrows(IllegalArgumentException.class, () -> {
            new Payment("fr13G8hJ-9a7f-4669-92F2-eaf539291cc0", null, order, paymentData);
        });
        paymentData.clear();
    }

    @Test
    void testCreatePaymentWithEmptyPaymentData() {
        paymentData.clear();
        assertThrows(IllegalArgumentException.class, () -> {
            new Payment("fr13G8hJ-9a7f-4669-92F2-eaf539291cc0", PaymentMethod.BANK.getValue(), order, paymentData);
        });
    }

    @Test
    void testCreatePaymentWithInvalidPaymentMethod() {
        loadBankTransferPaymentData();
        assertThrows(IllegalArgumentException.class, () -> {
            new Payment("fr13G8hJ-9a7f-4669-92F2-eaf539291cc0", "MEOW", order, paymentData);
        });
        paymentData.clear();
    }

    @Test
    void testCreatePaymentWithDefaultStatus() {
        loadBankTransferPaymentData();
        Payment payment = new Payment("fr13G8hJ-9a7f-4669-92F2-eaf539291cc0", PaymentMethod.BANK.getValue(), order, paymentData);
        assertSame(order, payment.getOrder());
        assertEquals("fr13G8hJ-9a7f-4669-92F2-eaf539291cc0", payment.getId());
        assertEquals(PaymentMethod.BANK.getValue(), payment.getMethod());
        assertEquals(paymentData, payment.getPaymentData());
        assertEquals(PaymentStatus.WAITING_PAYMENT.getValue(), payment.getStatus());
        paymentData.clear();
    }

    @Test
    void testCreatePaymentWithSuccessStatus() {
        loadBankTransferPaymentData();
        Payment payment = new Payment("fr13G8hJ-9a7f-4669-92F2-eaf539291cc0", PaymentMethod.BANK.getValue(), order, paymentData, PaymentStatus.SUCCESS.getValue());
        assertSame(order, payment.getOrder());
        assertEquals("fr13G8hJ-9a7f-4669-92F2-eaf539291cc0", payment.getId());
        assertEquals(PaymentMethod.BANK.getValue(), payment.getMethod());
        assertEquals(paymentData, payment.getPaymentData());
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
        paymentData.clear();
    }

    @Test
    void testCreatePaymentWithInvalidStatus() {
        loadBankTransferPaymentData();
        assertThrows(IllegalArgumentException.class, () -> {
            new Payment("fr13G8hJ-9a7f-4669-92F2-eaf539291cc0", PaymentMethod.BANK.getValue(), order, paymentData, "MEOW");
        });
        paymentData.clear();
    }

    @Test
    void testCreatePaymentWithRejectedStatus() {
        loadBankTransferPaymentData();
        Payment payment = new Payment("fr13G8hJ-9a7f-4669-92F2-eaf539291cc0", PaymentMethod.BANK.getValue(), order, paymentData, PaymentStatus.REJECTED.getValue());
        assertSame(order, payment.getOrder());
        assertEquals("fr13G8hJ-9a7f-4669-92F2-eaf539291cc0", payment.getId());
        assertEquals(PaymentMethod.BANK.getValue(), payment.getMethod());
        assertEquals(paymentData, payment.getPaymentData());
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }

    @Test
    void testSetPaymentStatusToRejected() {
        loadBankTransferPaymentData();
        Payment payment = new Payment("fr13G8hJ-9a7f-4669-92F2-eaf539291cc0", PaymentMethod.BANK.getValue(), order, paymentData);
        payment.setStatus(PaymentStatus.REJECTED.getValue());
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
        paymentData.clear();
    }

    @Test
    void testSetPaymentStatusToInvalidStatus() {
        loadBankTransferPaymentData();
        Payment payment = new Payment("fr13G8hJ-9a7f-4669-92F2-eaf539291cc0", PaymentMethod.BANK.getValue(), order, paymentData);
        assertThrows(IllegalArgumentException.class, () -> {
            payment.setStatus("MEOW");
        });
        paymentData.clear();
    }

    @Test
    void testSetPaymentStatusToSuccess() {
        loadBankTransferPaymentData();
        Payment payment = new Payment("fr13G8hJ-9a7f-4669-92F2-eaf539291cc0", PaymentMethod.BANK.getValue(), order, paymentData);
        payment.setStatus(PaymentStatus.SUCCESS.getValue());
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
        paymentData.clear();
    }

    @Test
    void testSetPaymentStatusToDefault() {
        loadBankTransferPaymentData();
        Payment payment = new Payment("fr13G8hJ-9a7f-4669-92F2-eaf539291cc0", PaymentMethod.BANK.getValue(), order, paymentData);
        payment.setStatus(PaymentStatus.WAITING_PAYMENT.getValue());
        assertEquals(PaymentStatus.WAITING_PAYMENT.getValue(), payment.getStatus());
        paymentData.clear();
    }

    @Test
    void testCreateVoucherPaymentButPaymentDataIncorrect() {
        loadBankTransferPaymentData();
        assertThrows(IllegalArgumentException.class, () -> {
            new Payment("fr13G8hJ-9a7f-4669-92F2-eaf539291cc0", PaymentMethod.VOUCHER.getValue(), order, paymentData);
        });
        paymentData.clear();
    }

    @Test
    void testCreateBankTransferPaymentButPaymentDataIncorrect() {
        loadVoucherPaymentData();
        assertThrows(IllegalArgumentException.class, () -> {
            new Payment("fr13G8hJ-9a7f-4669-92F2-eaf539291cc0", PaymentMethod.BANK.getValue(), order, paymentData);
        });
        paymentData.clear();
    }

    @Test
    void testCreateVoucherPaymentSuccess() {
        loadVoucherPaymentData();
        Payment payment = new Payment("fr13G8hJ-9a7f-4669-92F2-eaf539291cc0", PaymentMethod.VOUCHER.getValue(), order, paymentData);
        assertSame(order, payment.getOrder());
        assertEquals("fr13G8hJ-9a7f-4669-92F2-eaf539291cc0", payment.getId());
        assertEquals(PaymentMethod.VOUCHER.getValue(), payment.getMethod());
        assertEquals(paymentData, payment.getPaymentData());
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
        paymentData.clear();
    }

    @Test
    void testCreateBankTransferPaymentSuccess() {
        loadBankTransferPaymentData();
        Payment payment = new Payment("fr13G8hJ-9a7f-4669-92F2-eaf539291cc0", PaymentMethod.BANK.getValue(), order, paymentData);
        assertSame(order, payment.getOrder());
        assertEquals("fr13G8hJ-9a7f-4669-92F2-eaf539291cc0", payment.getId());
        assertEquals(PaymentMethod.BANK.getValue(), payment.getMethod());
        assertEquals(paymentData, payment.getPaymentData());
        assertEquals(PaymentStatus.WAITING_PAYMENT.getValue(), payment.getStatus());
        paymentData.clear();
    }
}
