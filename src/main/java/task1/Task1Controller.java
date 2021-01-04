package task1;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task1Controller {
    private final ArrayList<File> files = new ArrayList<>();
    private final ArrayList<Thread> threads = new ArrayList<>();
    private final File folder1 = new File("src/main/filesForTask1");
    private String nums = "";
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public Task1Controller() {
        makeNumStr();
    }

    public void run() {
        check();
        startRename();
    }

    private void makeNumStr() {
        int count = 1;
        for (File file : Objects.requireNonNull(folder1.listFiles())) {
            nums += count + " ";
            count++;
        }
        System.out.println(nums);
    }

    private void check() {
        for (File file : Objects.requireNonNull(folder1.listFiles())) {
            if (!getFileNum(((file.getName().contains(".")) ? file.getName().substring(0, file.getName().lastIndexOf(".")) : file.getName()))) {
                files.add(file);
            }
        }
    }

    //parse to int and check that it lower than folder size
    private boolean getFileNum(String fileName) {
        try {
            if (Integer.parseInt(fileName) <= Objects.requireNonNull(folder1.listFiles()).length) {
                nums = nums.replace(fileName + " ", "");
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return false;
    }

    private synchronized void startRename() {
        if (nums.trim().length() > 1) {
            String[] str = nums.split(" ");
            int count = 0;

            for (File file : files) {
                executor.execute(new Rename(file, Integer.parseInt(str[count])));
                count++;
            }
            executor.shutdown();


        } else if (nums.trim().length() == 1) {
            new Rename(files.get(0), Integer.parseInt(nums.trim()));
        }
    }

    public File getFolder1() {
        return folder1;
    }
}