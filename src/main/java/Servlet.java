import task1.Task1Controller;
import task2.Task2Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class Servlet extends HttpServlet {
    File folder2 = new File("src/main/filesForTask2");
    File folder1 = new File("src/main/filesForTask1");

    Task1Controller task1Controller = new Task1Controller();
    Task2Controller task2Controller;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("folder1", folder1);
        req.setAttribute("folder2", folder2.listFiles());

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("folder1", folder1);
        req.setAttribute("folder2", folder2.listFiles());

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }



}
