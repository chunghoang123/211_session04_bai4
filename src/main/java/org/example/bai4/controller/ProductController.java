package org.example.bai4.controller;

import org.example.bai4.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final List<Product> products = new ArrayList<>();

    public ProductController() {

        products.add(new Product("P001", "Laptop", 1500, 10));
        products.add(new Product("P002", "Mouse", 25, 50));
    }

    // PUT - cập nhật sản phẩm
    @PutMapping("/{productId}")
    public Object updateProduct(
            @PathVariable String productId,
            @RequestBody Product updatedProduct) {

        for (Product product : products) {

            if (product.getProductId().equals(productId)) {

                product.setProductName(updatedProduct.getProductName());
                product.setPrice(updatedProduct.getPrice());
                product.setQuantity(updatedProduct.getQuantity());

                return product;
            }
        }

        return "Product ID not found!";
    }

    // DELETE - xóa sản phẩm
    @DeleteMapping("/{productId}")
    public String deleteProduct(
            @PathVariable String productId) {

        for (Product product : products) {

            if (product.getProductId().equals(productId)) {

                products.remove(product);

                return "Deleted product with ID: " + productId;
            }
        }

        return "Product ID not found!";
    }
}