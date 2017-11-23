import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;
@WebServlet (urlPatterns = "json")
public class StuJson extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        jsonExample();
    }

    public void jsonExample() {
        Student stu = createDummyObject();
        Gson gson = new Gson();
        String Json = gson.toJson(stu);
        System.out.println("Hey ");
        try {
            FileWriter writer = new FileWriter("D:\\www.Test");
            gson.toJson(stu, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static Student createDummyObject() {

        Student stu = new Student();

        stu.setName("Sharon");
        stu.setGender("Female");
        stu.setId("6050");
        return stu;
    }
}
