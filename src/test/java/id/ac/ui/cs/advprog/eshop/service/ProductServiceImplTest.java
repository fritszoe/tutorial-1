package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    @InjectMocks
    ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testCreateAndFindAll() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productService.create(product);

        List<Product> productList = productService.findAll();
        assertFalse(productList.isEmpty());
        Product savedProduct = productList.get(0);
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }
    @Test
    void findAllIfEmpty() {
        List<Product> productList = productService.findAll();
        assertTrue(productList.isEmpty());
    }
    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo cap Bambang");
        product1.setProductQuantity(100);
        productService.create(product1);

        Product product2 = new Product();
        product2.setProductId("b652670f-2b39-46f3-a232-dd8fff1f60f6");
        product2.setProductName("Sampo cap Samsul");
        product2.setProductQuantity(70);
        productService.create(product2);

        List<Product> productList = productService.findAll();
        assertFalse(productList.isEmpty());
        Product savedProduct = productList.get(0);
        assertEquals(product1.getProductId(), savedProduct.getProductId());
        savedProduct = productList.get(1);
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertFalse(productList.isEmpty());
    }
    @Test
    void testEditProduct() {
        Product product = new Product();
        product.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product.setProductName("Sampo cap Bambang");
        product.setProductQuantity(100);
        productService.create(product);

        Product editedProduct = new Product();
        editedProduct.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        editedProduct.setProductName("Sampo cap Samsul");
        editedProduct.setProductQuantity(10);

        productService.edit(editedProduct);

        assertEquals("a0f9de46-90b1-437d-a0bf-d0821dde9096", product.getProductId());
        assertEquals("Sampo cap Samsul", product.getProductName());
        assertEquals(10, product.getProductQuantity());
    }
    @Test
    void testDelete() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo cap Bambang");
        product.setProductQuantity(100);
        productService.create(product);
        productService.delete(product);

        List<Product> productList = productService.findAll();
        assertTrue(productList.isEmpty());
    }
    @Test
    void testDeleteIfMoreThanOne() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo cap Bambang");
        product1.setProductQuantity(100);
        productService.create(product1);

        Product product2 = new Product();
        product2.setProductId("b652670f-2b39-46f3-a232-dd8fff1f60f6");
        product2.setProductName("Sampo cap Samsul");
        product2.setProductQuantity(70);
        productService.create(product2);

        productService.delete(product1);
        List<Product> productList = productService.findAll();
        assertFalse(productList.isEmpty());

        assertNull(productService.findById("eb558e9f-1c39-460e-8860-71af6af63bd6"));
        assertNotNull(productService.findById("b652670f-2b39-46f3-a232-dd8fff1f60f6"));
    }
}
