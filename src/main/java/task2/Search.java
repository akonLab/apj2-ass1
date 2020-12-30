package task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Search {
    FileReader fileReader;
    BufferedReader bufferedReader;
    HashMap<String, Integer> countWordsFromPhrase = null;

    void readTxt(Item item, String input) {
        try {
            fileReader = new FileReader(item.getFile().getPath());
            bufferedReader = new BufferedReader(fileReader);

            searchString(input);
            countWordsFromPhrase = searchWordsFromPhrase(input);

            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    Integer searchString(String input) {
        String str;
        int count = 0;
        try {
            while ((str = bufferedReader.readLine()) != null) {
                for (String word : str.split(" ")) {
                    if (word.toLowerCase().equals(input.toLowerCase())) {
                        count++;
                    }
                }
            }
            System.out.println("Count of " + input + " : " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;
    }

   private HashMap<String, Integer> searchWordsFromPhrase(String input) {
        String[] words = findAllWordsInPhrase(input);
        if (words.length > 1) {
            countWordsFromPhrase = new HashMap<>();
            for (String str : words) {
                countWordsFromPhrase.put(str, searchString(str));
            }
        }
        return countWordsFromPhrase;
    }

   private String[] findAllWordsInPhrase(String input) {
        String[] symbols = ",.<>/?;:\"[]{}`~!-_".split("");
        for (String str : symbols) input = input.replace(str, "");
        return input.replace("  ", " ").split(" ");
    }
}
