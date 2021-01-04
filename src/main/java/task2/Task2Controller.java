package task2;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task2Controller {
    private final File folder2 = new File("src/main/filesForTask2");
    private final ExecutorService executor = Executors.newCachedThreadPool();

    private ArrayList<Item> items;
    private final String input;


    public Task2Controller(String input) {
        this.input = input;
    }

    public void start() {
        setItems();
        startThread();

        if (executor.isShutdown()) {
            for (Item item : items) {
                System.out.println(item.getFile().getName() + " have count " + item.getCount());
            }
            sort();
        }

    }

    public void setItems() {
        items = new ArrayList<>();
        for (File file : Objects.requireNonNull(folder2.listFiles())) {
            items.add(new Item(file));
        }
    }

    private void startThread() {
        for (Item item : items) {
            executor.execute(new Search(item, input));
        }
        executor.shutdown();
    }

    private void sort() {
       items.sort(new CountComparator());
        for (Item item : items) {
            System.out.println(item.getFile().getName() + " have count " + item.getCount());
            System.out.println(item.getCountWordsFromPhrase());
        }
    }
}
