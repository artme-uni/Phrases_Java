package ru.nsu.g.akononov.phrases;

public class MainStream {

    public static void main(String[] args) {

        if (args.length == 0) {
            String[] arg = new String[1];
            arg[0] = "-";
            Parser.parse(arg);
        } else
            Parser.parse(args);

        Frequency temp = new FrequencyStream(Parser.input, Parser.phraseLength, Parser.repeatCount);
        temp.phrases_count();
    }
}