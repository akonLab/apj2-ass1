package task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Search extends Thread {
    private HashMap<String, Integer> countWordsFromPhrase = null;
    private final Item item;
    private final String input;

    public Search(Item item, String input) {
        this.item = item;
        this.input = input;
    }

    @Override
    public synchronized void run() {
        if (item.getFile().getName().substring(item.getFile().getName().lastIndexOf('.')+1).equals("txt")) {//if txt
            item.setCountWordsFromPhrase(searchWordsFromInput());
            item.setCount(searchStringInText(input) + searchFileName() + sumValues());

            System.out.println(item.getFile().getName() + countWordsFromPhrase);
            System.out.println(item.getCount());
        } else {
            item.setCount(searchFileName());
        }
    }

    private Integer sumValues() {
        int count = 0;

        if (item.getCountWordsFromPhrase() != null)
            for (Integer num : item.getCountWordsFromPhrase().values())
                count += num;

        return count;
    }

    protected Integer searchFileName() {
        int count = 0;

        //search the whole input with file name
        if (item.getFile().getName().contains(".") && item.getFile().getName().substring(0, item.getFile().getName().lastIndexOf('.')).toLowerCase().equals(input.toLowerCase())) {
            count++;
        } else {//if file
            if (item.getFile().getName().equals(input)) {
                count++;
            }
        }

        String[] inputWords = findAllWordsInPhrase(input);

        /*
        if (item.getFile().getName().contains(".")) {
            fileNameWords = findAllWordsInPhrase(item.getFile().getName().substring(0, item.getFile().getName().lastIndexOf('.')));
        } else {
            fileNameWords = findAllWordsInPhrase(item.getFile().getName());
        }
*/

        String[] fileNameWords = findAllWordsInPhrase((item.getFile().getName().contains(".")) ? item.getFile().getName().substring(0, item.getFile().getName().lastIndexOf('.')) : item.getFile().getName());

        //search the input with file name by part
        if (inputWords.length > 1) {
            for (String strInp : inputWords) {
                for (String strFile : fileNameWords) {
                    if (strFile.toLowerCase().equals(strInp.toLowerCase())) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    protected Integer searchStringInText(String input) {
        String str;
        int count = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(item.getFile().getPath()));

            while ((str = bufferedReader.readLine()) != null) {
                for (String word : str.split(" ")) {
                    if (word.toLowerCase().equals(input.toLowerCase())) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;
    }

    protected HashMap<String, Integer> searchWordsFromInput() {
        String[] words = findAllWordsInPhrase(input);
        if (words.length > 1) {
            countWordsFromPhrase = new HashMap<>();
            for (String str : words) {
                countWordsFromPhrase.put(str, searchStringInText(str));
            }
        }
        return countWordsFromPhrase;
    }

    //prepare string for search(replace symbols and split it)
    private String[] findAllWordsInPhrase(String word) {
        String[] symbols = ",.<>/?;:\"[]{}`~!-_".split("");
        for (String str : symbols) {
            word = word.replace(str, " ");
        }
        return word.replace("  ", " ").split(" ");
    }
}
