
package controllers;

import entities.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
@WebServlet(name="ELServlet", urlPatterns={"/ELServlet"})
public class ELServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Truyền 1 biến từ Servlet -> JSP
        req.setAttribute("name", "Phạm Minh Châu");
        
        // Truyền 1 đối tượng từ Servlet -> JSP
        User userObject = new User(1, "Nguyễn Bình Minh", 20);
        req.setAttribute("user", userObject);
        
        // Tổ chức 1 list dữ liệu kiểu User
        List<User> listUser = new ArrayList<>();
        listUser.add(new User(2, "Tom", 21));
        listUser.add(new User(3, "Marry", 19));
        listUser.add(new User(4, "John", 22));
        req.setAttribute("listUser", listUser);
        
        req.getRequestDispatcher("Topic1_basicCalc_EL.jsp").forward(req, resp);
    }
}
