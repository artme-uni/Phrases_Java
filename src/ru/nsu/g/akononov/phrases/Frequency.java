package ru.nsu.g.akononov.phrases;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class Frequency {

    protected String input;
    protected int phraseLength;
    protected int repeatCount;

    protected ArrayList<String> words = new ArrayList<>();
    protected ArrayList<String> phrases = new ArrayList<>();
    protected Map<String, Integer> freq = new HashMap<>();

    Frequency(String input, int phraseLength, int repeatCount) {
        this.input = input;
        this.phraseLength = phraseLength;
        this.repeatCount = repeatCount;
    }

    public void scan_words(Scanner s) throws IOException{

        while (s.hasNext()) {
            words.add(s.next());
        }
    }

    protected void WordsToPhrases()
    {
        StringBuilder temp_str = new StringBuilder();

        int size = words.size();
        for (int i = 0; i < size - phraseLength + 1; i++) {

            temp_str.setLength(0);
            for (int j = 0; j < phraseLength; j++) {
                temp_str.append(words.get(j)).append(" ");
            }

            phrases.add(temp_str.toString());
            words.remove(0);
        }
    }
    protected abstract void print_phrases();

    public void phrasesCounter()
    {
        try {
            Scanner s;

            if(input.equals("-")) {
                s = new Scanner(System.in);
            } else
            {
                File file = new File(input);
                s = new Scanner(file);
            }

            scan_words(s);
            print_phrases();

            s.close();

        } catch (RuntimeException | IOException e) {
            System.out.println(e.toString());
        }

    }
}