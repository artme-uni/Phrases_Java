package ru.nsu.g.akononov.phrases;

import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class FrequencyStream extends Frequency {

    public FrequencyStream(String input, int phraseLength, int repeatCount) {
        super(input, phraseLength, repeatCount);
    }

    @Override
    public void print_phrases() {

        WordsToPhrases();

        phrases.stream().collect(Collectors.groupingBy(s -> s, counting()))
                .entrySet()
                .stream()
                .sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue()))
                .filter(s -> s.getValue() >= repeatCount)
                .forEach(s -> System.out.println(s.getKey() + "(" + s.getValue() + ")"));

    }
}
