package ru.nsu.g.akononov.phrases;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FrequencyList extends Frequency {

    public FrequencyList(String input, int phraseLength, int repeatCount) {
        super(input, phraseLength, repeatCount);
    }

    @Override
    protected void print_phrases() {

        WordsToPhrases();

        phrases.forEach(s -> freq.putIfAbsent(String.valueOf(s), 0));
        phrases.forEach(s -> freq.put(String.valueOf(s), freq.get(String.valueOf(s)) + 1));

        List<Map.Entry<String, Integer>> result = new LinkedList<>(freq.entrySet());

        result.sort((o1, o2) -> (o2.getValue() - o1.getValue()));

        for (Map.Entry<String, Integer> a : result) {
            if (a.getValue() >= repeatCount) {
                System.out.println(a.getKey() + "(" + a.getValue() + ")");
            }
        }
    }
}