package task1;

import java.io.File;

public class Rename extends Thread{
    private final Integer count;
    private final File file;

    public Rename(File file, Integer count) {
        this.file = file;
        this.count = count;
    }

    @Override
    public void run() {
        String format = file.getName().substring(file.getName().lastIndexOf("."));

        if (file.renameTo(new File(file.getParentFile().getPath() + "/" + count + format))) {
            System.out.println(file.getName());
        }
    }

}
