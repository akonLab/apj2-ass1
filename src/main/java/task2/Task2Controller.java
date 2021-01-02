package task2;

import comparators.CountComparator;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task2Controller {
    private final File folder2 = new File("src/main/filesForTask2");
    private final ExecutorService executor = Executors.newCachedThreadPool();

    private final ArrayList<Item> items;
    private final String input;


    public Task2Controller(String input) {
        this.input = input;
        items = new ArrayList<>();
    }

    public void start() {
        for (File file : Objects.requireNonNull(folder2.listFiles())) {
            items.add(new Item(file));
        }
        startThread();
        if (executor.isShutdown()) {
            sort();
        }


    }

    private void startThread() {
        for (Item item : items) {
            executor.execute(new Search(item, input));
        }if (!executor.isTerminated()){
            executor.shutdownNow();
        }

    }

    private void sort() {
        items.sort(new CountComparator());
        for (Item item : items) {
            System.out.println(item.getFile().getName() + " have count " + item.getCount());
            System.out.println(item.getCountWordsFromPhrase());
        }
    }
}
