import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Calculate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        // Điều hướng tới calculate.html, giữ nguyên url pattern của servlet này
        request.getRequestDispatcher("calculate.html").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            // Lấy dữ liệu của number1, number2 trên Form
            double number1 = Double.parseDouble(request.getParameter("n1"));
            double number2 = Double.parseDouble(request.getParameter("n2"));
            out.println("Tổng = " + (number1+number2));
        } catch (Exception e) {
            out.println("Lỗi: " + e.getMessage());
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
