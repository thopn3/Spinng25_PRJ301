
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class RectangleServlet1 extends HttpServlet {
   @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Điều hướng tới UI: rectangle.html
        req.getRequestDispatcher("rectangle_1.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        try {
            double d = Double.parseDouble(req.getParameter("dai"));
            double r = Double.parseDouble(req.getParameter("rong"));
            String[] tinh = req.getParameterValues("tinhtoan");
            String msg = "";
            
            if(tinh == null)
                msg = "Vui lòng chọn tính năng để tính!";
            else if(tinh.length==2)
                msg = "Diện tích = " + (d*r) + "<br/> Chu vi = " + (d+r)*2;
            else if(tinh[0].equals("0"))
                msg = "Diện tích = " + (d*r);
            else
                msg = "Chu vi = " + (d+r)*2;
            
            out.println("<h2>"+msg+"</h2>");
        } catch (Exception e) {
            // Báo lỗi trường hợp: Nhập sai kiểu dữ liệu của double hoặc để trống: dài, rộng
            out.println("<div style='color:red'>Vui lòng nhập đúng dữ liệu để tính toán!</div>");
        }
    }
}
