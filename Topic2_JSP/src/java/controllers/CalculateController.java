package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;

/**
 *
 * @author admin
 */
@WebServlet(name="CalculateController", urlPatterns={"/calc"})
public class CalculateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Điều hướng tới calculator1.jsp khi có yêu cầu từ client tới /calc
        req.getRequestDispatcher("calculate1.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            double price = Double.parseDouble(req.getParameter("price"));
            double totalPrice = price + 0.1*price;
            // Chuyển tiếp dữ liệu sau khi tính toán về calculate1.jsp
            req.setAttribute("result", new DecimalFormat("##.##").format(totalPrice));
            req.getRequestDispatcher("calculate1.jsp").forward(req, resp);
            
        } catch (Exception e) {
            // Gán thông điệp lỗi cho 1 thuộc tính của đối tượng request
            req.setAttribute("error", e.getMessage());
            // Chuyển tiếp kèm dữ liệu về calculate1.jsp để hiển thị lỗi
            req.getRequestDispatcher("calculate1.jsp").forward(req, resp);
        }
    }
}
