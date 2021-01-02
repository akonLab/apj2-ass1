package task2;

import java.io.File;
import java.util.HashMap;

public class Item {
    private final File file;
    private HashMap<String, Integer> countWordsFromPhrase=new HashMap<>();
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

    public void setCountWordsFromPhrase(HashMap<String, Integer> countWordsFromPhrase) {
        this.countWordsFromPhrase = countWordsFromPhrase;
    }

    public HashMap<String, Integer> getCountWordsFromPhrase() {
        return countWordsFromPhrase;
    }
}
