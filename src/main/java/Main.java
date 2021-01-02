import task1.Rename;
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
        String input = "pdf the a text 1";
        System.out.println("input is '" + input + "'\n");

        Task2Controller contr = new Task2Controller(input);
        contr.start();
        // contr.getCount(input);


        //search in txt
        //  new Search(new Item(new File("src/main/filesForTask2/article_1.txt"))).readTxt("the a".trim());
/*
        ExecutorService executor = Executors.newCachedThreadPool();
        int count=1;
        for (File file : Objects.requireNonNull(new File("src/main/filesForTask1").listFiles())) {
            executor.execute(new Rename(file,count));
            count++;
        }
 */

    }
}
