/**
 * @author Juan Gomez
 * @email jgomezblandon@mail.valenciacollege.edu
 * @date 11/03/2021
 */
package TextCounterTest;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        String filePath = "/Users/amy/Documents/Valencia College/Fall 2021/Mobile Dev/Week 2/TextCounterJuanGomez/";
        String fileName = "poem.txt";

        WordFrequencies frequency = new WordFrequencies();

        try {
            File file = new File(filePath + fileName);
            Scanner sc = new Scanner(file);
            HashMap<String, Integer> wordCountHolder = new HashMap<String, Integer>();
            AtomicInteger position = new AtomicInteger(1);

            // Evaluates every word in the file to find frecuency
            while (sc.hasNext()) {
                String word = sc.next();
                frequency.insertWord(word);
            }

            System.out.println("\n");
            System.out.println("   Word      Frecuency");
            System.out.println("______________________");
            frequency.wordCountHolder.entrySet().stream()
                    .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                    .forEach(k -> {
                        System.out.println(position + ". " + k.getKey() + "        " + k.getValue());
                        position.getAndIncrement();
                    });

        } catch (Exception e) {
            System.out.println(e);

        }

    }
}
