import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RectangleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Điều hướng tới UI: rectangle.html
        req.getRequestDispatcher("rectangle.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        try {
            double d = Double.parseDouble(req.getParameter("dai"));
            double r = Double.parseDouble(req.getParameter("rong"));
            String dientich = req.getParameter("area");
            String chuvi = req.getParameter("perimeter");
            String msg = "";
            
            if(dientich==null && chuvi==null)
                msg = "Yêu cầu chọn chức năng để tính!";
            else if(dientich!=null && chuvi==null)
                msg = "Diện tích HCN = " + (d*r);
            else if(dientich==null && chuvi!=null)
                msg = "Chu vi HCN = " + (d+r)*2;
            else
                msg = "Diện tích HCN = " + (d*r) + "<br/>" + "Chu vi HCN = " + (d+r)*2;
            
            out.println("<h2>"+msg+"</h2>");
        } catch (Exception e) {
            // Báo lỗi trường hợp: Nhập sai kiểu dữ liệu của double hoặc để trống: dài, rộng
            out.println("<div style='color:red'>Vui lòng nhập đúng dữ liệu để tính toán!</div>");
        }
    }
}
