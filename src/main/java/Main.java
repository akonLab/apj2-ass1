import task1.Rename;
import task1.Task1Controller;
import task2.Item;
import task2.Task2Controller;

import java.io.File;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        //task2
        //search bu file.name
/*
        String input = "pdf the a text 1";
        System.out.println("input is '" + input + "'\n");
        //  //
       Task2Controller contr = new Task2Controller(input);
        contr.start();

        // contr.getCount(input);

*/
        //task1

        Task1Controller task1Controller = new Task1Controller();

        task1Controller.run();
        //  //   System.out.println(Integer.parseInt("article_1"));

    }
}
