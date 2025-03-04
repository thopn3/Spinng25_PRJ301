
package dal;

import java.util.List;
import models.Category;
import java.sql.*;
import java.util.ArrayList;

public class CategoryDAO extends DBContext{
    public CategoryDAO(){
        super();
    }
    
    public List<Category> getCategories(){
        List<Category> categories = new ArrayList<>();
        try {
            String sql = "select * from categories";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Category c = new Category(
                        rs.getInt("Id"), 
                        rs.getString("Name"), 
                        rs.getString("Description")
                );
                categories.add(c);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return categories;
    }
    
    public static void main(String[] args) {
        System.out.println(new CategoryDAO().getCategories().size());
    }
}
