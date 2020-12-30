import task1.Rename;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServletTask1 extends HttpServlet {
    ExecutorService executor = Executors.newCachedThreadPool();
    File folder = new File("src/main/filesForTask1");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    void run() {
        int count = 1;
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            executor.execute(new Rename(file, count));
            count++;
        }
    }
}
