package dal;

import dto.ProductDTO;
import java.util.ArrayList;
import java.util.List;
import models.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductDAO extends DBContext {

    public ProductDAO() {
        super();
    }

    // R: List all products
    public List<ProductDTO> getAllProducts() throws Exception {
        // Khai báo danh sách chứa các đối tượng kiểu Product
        List<ProductDTO> products = new ArrayList<>();
        try {
            // Tạo truy vấn lấy dữ liệu từ DB
            String sql = "select p.Id, p.Name, p.Price, p.Quantity, c.Name as cName\n"
                    + "from Products p, Categories c\n"
                    + "where p.CategoryId = c.Id";
            // Thực thi truy vấn
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            // Đọc dữ liệu vào list products
            while (rs.next()) {
                // Đọc từng bản ghi dữ liệu để đưa vào đối tượng kiểu Product
                int id = rs.getInt("Id"); // Tên các trường từ DB
                String name = rs.getString("Name");
                int price = rs.getInt("Price");
                int quantity = rs.getInt("Quantity");
                String catName = rs.getString("cName");
                ProductDTO product = new ProductDTO(id, name, price, quantity, catName);
                products.add(product);
            }
        } catch (Exception e) {
            throw new Exception(e);
        }
        return products;
    }
    
    // R: Get a single Product by Id
    public Product getProduct(int id){
        Product product = null;
        try {
            String sql = "select * from Products where Id="+id;
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){ // Kiểm tra xem có tồn tại dữ liệu từ ResultSet không
                int pId = rs.getInt("Id");
                String name = rs.getString("Name");
                int price = rs.getInt("Price");
                int quantity = rs.getInt("Quantity");
                int catId = rs.getInt("CategoryId");
                product = new Product(pId, name, price, quantity, catId);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return product;
    }
    
    // D: Delete product by Id
    public boolean deleteProduct(int id){
        try {
            String sql = "delete from Products where Id=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            int count = st.executeUpdate();
            if(count>0)
                return true;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
}
