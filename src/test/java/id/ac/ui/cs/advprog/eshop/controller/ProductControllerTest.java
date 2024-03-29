package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {
    @Mock
    private ProductService productService;
    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testCreateProductPage() {
        Model model = new BindingAwareModelMap();
        String taskName = productController.createProductPage(model);
        assertEquals("CreateProduct", taskName);
    }

    @Test
    void testCreateProductPost() {
        Product product = new Product();
        Model model = new BindingAwareModelMap();
        String viewName = productController.createProductPost(product, model);
        assertEquals("redirect:list", viewName);
        verify(productService, times(1)).create(product);
    }

    @Test
    void testProductListPage() {
        Model model = new BindingAwareModelMap();
        String taskName = productController.productListPage(model);
        assertEquals("ProductList", taskName);
        assertTrue(model.containsAttribute("products"));
    }

    @Test
    void testEditProductPage() {
        String productId = "eb558e9f-1c39-460e-8860-71af6af63bd6";
        Product product = new Product();
        product.setProductId(productId);
        productService.create(product);

        when(productService.findById(productId)).thenReturn(product);

        Model model = new BindingAwareModelMap();
        String viewName = productController.editProductPage(productId, model);

        assertEquals("editProduct", viewName);
        assertEquals(product, model.getAttribute("product"));
        verify(productService, times(1)).findById(productId);
    }
    @Test
    void testEditProductPost() {
        Product product = new Product();
        String productId = "eb558e9f-1c39-460e-8860-71af6af63bd6";

        product.setProductId(productId);
        product.setProductName("Botol Air");
        product.setProductQuantity(1);
        productService.create(product);

        Model model = new BindingAwareModelMap();
        String viewName = productController.editProductPost(productId, model, product);
        assertEquals("redirect:../list", viewName);
        verify(productService, times(1)).edit(product);
    }
    @Test
    void testDeleteProductPost() {
        Product product = new Product();
        String productId = "eb558e9f-1c39-460e-8860-71af6af63bd6";

        product.setProductId(productId);
        product.setProductName("Botol Air");
        product.setProductQuantity(1);
        productService.create(product);

        when(productService.findById(productId)).thenReturn(product);

        Model model = new BindingAwareModelMap();
        String viewName = productController.deleteProduct(productId);
        assertEquals("redirect:../list", viewName);
        verify(productService, times(1)).delete(product);
    }
}
