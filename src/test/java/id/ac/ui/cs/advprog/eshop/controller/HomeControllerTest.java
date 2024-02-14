package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class HomeControllerTest {
    private HomeController homeController;
    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = mock(ProductService.class);
        homeController = new HomeController();
    }

    @Test
    void testCreateProductPage() {
        Model model = new BindingAwareModelMap();
        String taskName = homeController.createHomePage(model);
        assertEquals("HomePage", taskName);
    }
}
