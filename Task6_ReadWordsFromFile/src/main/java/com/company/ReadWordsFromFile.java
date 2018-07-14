package com.company;

import org.apache.commons.lang3.mutable.MutableInt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadWordsFromFile {
    public static void main(String[] args) {
        Scanner scanner = null;
        List<String> lines = new ArrayList<>();
        try {
            scanner = new Scanner(new File("Task6_ReadWordsFromFile/src/main/resources/fileForReading"))
                    .useDelimiter("\\s+");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //считаем сколько раз каждое слово встречается в файле:
        Map<String, MutableInt> elementsFrequency = new HashMap<>();
        while (scanner.hasNext()) {
            String word = scanner.next();
            lines.add(word);
            elementsFrequency
                    .computeIfAbsent(word, w -> new MutableInt())
                    .increment();
        }
        System.out.println("Cчитаем сколько раз каждое слово встречается в файле: " + elementsFrequency);

        //сортируем слова в алфавитном порядке:
        Collections.sort(lines);
        System.out.print("Сортируем слова в алфавитном порядке: ");
        for (String x : lines) {
            System.out.print(x + " ");
        }

        //находим слово с максимальным количеством повторений:
        List<Map.Entry<String, MutableInt>> freqItems = new ArrayList<>(elementsFrequency.entrySet());
        freqItems.sort(
                Comparator
                        .comparingInt(
                                (Map.Entry<String, MutableInt> v) -> v.getValue().intValue()
                        )
                        .reversed()
        );
        int maxCount = freqItems.get(0).getValue().intValue();
        for (int i = 0; i < freqItems.size(); i++) {
            Map.Entry<String, MutableInt> entry = freqItems.get(i);
            if (entry.getValue().intValue() < maxCount) {
                break;
            }
            System.out.print("\n" + entry);
        }
    }
}
