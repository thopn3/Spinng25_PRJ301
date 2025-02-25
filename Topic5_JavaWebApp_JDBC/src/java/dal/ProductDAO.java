package dal;

import java.util.ArrayList;
import java.util.List;
import models.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductDAO extends DBContext{
    public ProductDAO(){
        super();
    }
    
    // R: List all products
    public List<Product> getAllProducts() throws Exception{
        // Khai báo danh sách chứa các đối tượng kiểu Product
        List<Product> products = new ArrayList<>();
        try {
            // Tạo truy vấn lấy dữ liệu từ DB
            String sql = "select * from Products";
            // Thực thi truy vấn
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            // Đọc dữ liệu vào list products
            while(rs.next()){
                // Đọc từng bản ghi dữ liệu để đưa vào đối tượng kiểu Product
                int id = rs.getInt("Id"); // Tên các trường từ DB
                String name = rs.getString("Name");
                int price = rs.getInt("Price");
                int quantity = rs.getInt("Quantity");
                int catId = rs.getInt("CategoryId");
                Product product = new Product(id, name, price, quantity, catId);
                products.add(product);
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
        return products;
    }
}
