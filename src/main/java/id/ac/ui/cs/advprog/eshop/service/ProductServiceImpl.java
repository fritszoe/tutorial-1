package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository = new ProductRepository();

    @Override
    public Product create (Product product) {
        productRepository.create(product);
        return product;
    }

    @Override
    public List<Product> findAll() {
        Iterator<Product> productIterator = productRepository.findAll();
        List<Product> allProduct = new ArrayList<>();
        productIterator.forEachRemaining(allProduct::add);
        return allProduct;
    }

    @Override
    public Product findById (String productId) {
        return productRepository.findById(productId);
    }

    @Override
    public Product edit (Product edited) {
        Product product = productRepository.findById(edited.getProductId());
        return productRepository.edit(product, edited);
    }

    @Override
    public Product delete (Product product) {
        return productRepository.delete(product);
    }
}
