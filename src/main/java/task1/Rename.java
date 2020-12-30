package task1;

import java.io.File;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Rename implements Runnable {
    //
    Integer count;
    File file;
    ExecutorService executor = Executors.newCachedThreadPool();

    public Rename(File file, Integer count) {
        this.file = file;
        this.count = count;
    }

    @Override
    public void run() {
        rename();
    }

    public void rename() {
        // item.getFile().getPath().replace(item.getFile().getName(),count);
        String format = file.getName().substring(file.getName().lastIndexOf("."));

        if (file.renameTo(new File(file.getParentFile().getPath() + "/" + count + format))) {
            System.out.println(file.getName());
        }
    }
/*
*
    public void filter(){

        int count=1;
        for (File file : Objects.requireNonNull(new File("src/main/filesForTask1").listFiles())) {
            executor.execute(new Rename(file,count));
            count++;
        }
    }
    * */
}
