import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;

public class Lab1Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("lab1.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        try {
            String name = req.getParameter("txtFullname");
            String score = req.getParameter("txtScore");
            String gender = req.getParameter("rbGender");
            String course = req.getParameter("ddlCourse");
            String msg = "";
            
            if(name.isEmpty() || score.isEmpty())
                msg = "Họ tên và Điểm không được để trống!";
            else if(!name.isEmpty() && !score.isEmpty()){
                double newScore = Double.parseDouble(score);
                String newGender = gender.equals("male")?"Mr ":"Mss ";
                if(newScore>=5)
                    msg = "<div style='font-size:18pt;font-weight:bold'>Xin chào "+ newGender + name + "</div><br/><span style='color:green'>Chúc mừng bạn đã qua môn <b>"+course+"</b>!</span>";
                else
                    msg = "<div style='font-size:18pt;font-weight:bold'>Xin chào "+ newGender + name + "</div><br/><span style='color:red'>Xin chia buồn! Chúc bạn may mắn môn <b>"+course+"</b> kỳ sau.</span>";
            }
            out.println(msg);
        } catch (Exception e) {
            out.println("Điểm yêu cầu phải là số!");
        }
    }
}
