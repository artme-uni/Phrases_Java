package ru.nsu.g.akononov.phrases;

public class MainList {

    public static void main(String[] args) {

        if (args.length == 0) {
            String[] arg = new String[1];
            arg[0] = "-";
            Parser.parse(arg);
        } else
            Parser.parse(args);

        Frequency temp = new FrequencyList(Parser.input, Parser.phraseLength, Parser.repeatCount);
        temp.phrases_count();
    }
}
