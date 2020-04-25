package ru.nsu.g.akononov.phrases;

public class MainStream {

    public static void main(String[] args) {

        Parser.parse(args);

        Frequency temp = new FrequencyStream(Parser.inputFile, Parser.phraseLength, Parser.repeatCount);
        temp.phrasesCounter();
    }
}