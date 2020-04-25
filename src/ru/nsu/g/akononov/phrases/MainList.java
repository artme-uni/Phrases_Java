package ru.nsu.g.akononov.phrases;

public class MainList {

    public static void main(String[] args) {

        Parser.parse(args);

        Frequency temp = new FrequencyList(Parser.inputFile, Parser.phraseLength, Parser.repeatCount);
        temp.phrasesCounter();
    }
}
