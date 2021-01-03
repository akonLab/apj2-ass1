package task1;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Rename implements Runnable {
   private final Integer count;
    private final File file;
    ExecutorService executor = Executors.newCachedThreadPool();
    ArrayList<Integer> numNames = new ArrayList<>();

    public Rename(File file, Integer count) {
        this.file = file;
        this.count = count;
    }

    @Override
    public void run() {check();
        System.out.println(numNames);
     //   rename();
    }

    public void rename() {
        // item.getFile().getPath().replace(item.getFile().getName(),count);
        String format = file.getName().substring(file.getName().lastIndexOf("."));

        if (file.renameTo(new File(file.getParentFile().getPath() + "/" + count + format))) {
            System.out.println(file.getName());
        }
    }

    void check() {
        if (file.getName().contains(".")) {
            numNames.add(Integer.parseInt(file.getName().substring(0, file.getName().lastIndexOf("."))));
        } else {
            numNames.add(Integer.parseInt(file.getName()));
        }
    }
}
