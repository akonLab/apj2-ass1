package task2;

import java.io.File;

public class Item {
    private final File file;
    private int count = 0;

    public Item(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
