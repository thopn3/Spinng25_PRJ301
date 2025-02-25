package models;

import entities.Product;
import java.util.Arrays;
import java.util.List;

public class ProductModel {
    public List<Product> products;
    public ProductModel(){
        // Khởi tạo dữ liệu ban đầu cho products
        products = Arrays.asList(
                new Product(1, "Product 1", 10.5, "p1.jpg"),
                new Product(2, "Product 2", 20.5, "p2.jpg;p21.jpg"),
                new Product(3, "Product 3", 15.4, "p3.jpg")
        );
    }
    
    // Trả về danh sách các products từ DB
    public List<Product> getProducts(){
        return products;
    }
    
    // Trả về product theo id
    /***
     * Get a single product
     * @param id
     * @return Product
     */
    public Product getProduct(int id){
        for (Product product : products) {
            if(product.getId() == id)
                return product;
        }
        return null;
    }
}
