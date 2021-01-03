package task1;

import org.apache.tools.ant.types.FileList;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class Task1Controller {
    ArrayList<File> files = new ArrayList<>();
    private final File folder1 = new File("src/main/filesForTask1");
    String nums = "";

    public File getFolder1() {
        return folder1;
    }

    public void makeNumStr() {
        int count = 1;
        for (File file : Objects.requireNonNull(folder1.listFiles())) {
            nums += count + " ";
            count++;
        }
        nums = nums.trim();
        System.out.println(nums);
    }

    public void check() {
        for (File file : Objects.requireNonNull(folder1.listFiles())) {
            if (!getFileNum(((file.getName().contains(".")) ? file.getName().substring(0, file.getName().lastIndexOf(".")) : file.getName()))) {
                files.add(file);
            }
            //abu
            file.getName().substring(0, file.getName().lastIndexOf("."));//2.pdf 2

        }
    }

    //parse to int and check that it lower than folder size
    private boolean getFileNum(String fileName) {
        if (Integer.parseInt(fileName) <= Objects.requireNonNull(folder1.listFiles()).length) {
            nums = nums.replace(fileName, "");
            return true;
        }
        return false;
    }

    void run() {

    }

}

