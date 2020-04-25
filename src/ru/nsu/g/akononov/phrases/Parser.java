package ru.nsu.g.akononov.phrases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    static protected int phraseLength = 2;
    static protected int repeatCount = 2;
    static String inputFile;

    public static void parse(String[] args) {

        if (args.length > 5 ||
                (args.length == 1 && args[0].equals("-help"))) {
            help();
            System.exit(-1);
        }

        List<String> arguments = new ArrayList<>(Arrays.asList(args));

        for (int i = 0; i < arguments.size(); ) {
            if (arguments.get(i).equals("-n")) {
                phraseLength = Integer.parseInt(arguments.get(i + 1));
                arguments.remove(i + 1);
                arguments.remove(i);
                continue;
            }

            if (arguments.get(i).equals("-m")) {
                repeatCount = Integer.parseInt(arguments.get(i + 1));
                arguments.remove(i + 1);
                arguments.remove(i);
                continue;
            }
            i++;
        }


        if (arguments.size() > 1) {
            help();
            System.exit(-1);
        }

        if (arguments.size() == 0) {
            inputFile = "-";
        } else {
            inputFile = arguments.get(0);
        }
    }

    public static void help() {
        System.out.println("Expected input: ./program input.txt\n" +
                "If input.txt not specified, stdin used\n\n" +
                "Optional args: \n\t-n phrase_length\n" +
                "\t-m repeat_count");
    }
}