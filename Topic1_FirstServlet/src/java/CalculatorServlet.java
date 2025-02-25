import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("basic_calculator.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        try {
            double n1 = Double.parseDouble(req.getParameter("n1"));
            double n2 = Double.parseDouble(req.getParameter("n2"));
            String op = req.getParameter("op");
            out.println(computeNumbers(n1,n2,op));
        } catch (Exception e) {
            out.println("Yêu cầu nhập đúng n1 và n2!");
        }
    }

    private String computeNumbers(double n1, double n2, String op) {
        String result = "";
        switch (op) {
            case "+":
                result = "Tổng = " + (n1+n2);
                break;
            case "-":
                result = "Hiệu = " + (n1-n2);
                break;
            case "*":
                result = "Tích = " + (n1*n2);
                break;
            case "/":
                if(n2==0)
                    result = "Mẫu số không được phép = 0!";
                else
                    result = "Thương = " + (n1/n2);
                break;
        }
        return result;
    }
}
