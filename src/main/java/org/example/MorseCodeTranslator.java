package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MorseCodeTranslator {

    private final Map<Character, String> englishToMorse = new HashMap<>();
    private final Map<String, Character> morseToEnglish = new HashMap<>();

    public MorseCodeTranslator() {
        initializeValues();
    }

    private void initializeValues() {
        char[] chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.', ',', '?', '\'', '!', '/', '(', ')', '&', ':', ';', '=', '+', '-', '_', '"', '$', '@'};
        String[] morseCodes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", "-----", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", ".-.-.-", "--..--", "..--..", ".----.", "-.-.--", "-..-.", "-.--.", "-.--.-", ".-...", "---...", "-.-.-.", "-...-", ".-.-.", "-....-", "..--.-", ".-..-.", "...-..-", ".--.-."};

        for (int i = 0; i < chars.length; i++) {
            englishToMorse.put(chars[i], morseCodes[i]);
            morseToEnglish.put(morseCodes[i], chars[i]);
        }
    }


    public String textToMorse(String text) {
        StringBuilder morseCode = new StringBuilder();
        for (char c : text.toUpperCase().toCharArray()) {
            if (englishToMorse.containsKey(c)) {
                morseCode.append(englishToMorse.get(c)).append(" ");
            } else if (c == ' ') {
                morseCode.append("/ ");
            } else {
                throw new IllegalArgumentException("Invalid character: " + c);
            }
        }
        return morseCode.toString().trim();
    }

    public String morseToText(String morse) {
        StringBuilder englishText = new StringBuilder();
        String[] words = morse.split("  ");
        for (String word : words) {
            String[] letters = word.split(" ");
            for (String letter : letters) {
                if (morseToEnglish.containsKey(letter)) {
                    englishText.append(morseToEnglish.get(letter));
                } else if (letter.equals("/")) {
                    englishText.append(" ");
                } else {
                    throw new IllegalArgumentException("Invalid Morse code: " + letter);
                }
            }
            englishText.append(" ");
        }
        return englishText.toString().trim();
    }

    public static void main(String[] args) {
        MorseCodeTranslator translator = new MorseCodeTranslator();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Morse Code Translator(-. <-> abcd): ");
        while (true) try {
            System.out.println("\nEnter a choice:\n1. English to Morse Code\n2. Morse Code to English\n3. Exit");
            int choice = scanner.nextInt(); scanner.nextLine();
            switch (choice) {
                case 1: System.out.println("Morse Code: " + translator.textToMorse(scanner.nextLine())); break;
                case 2: System.out.println("English Text: " + translator.morseToText(scanner.nextLine())); break;
                case 3: System.out.println("Exit"); scanner.close(); return;
                default: System.out.println("Invalid choice.");
            }
        } catch (Exception e) {
            System.out.println(e instanceof IllegalArgumentException ? "Error: " + e.getMessage() : "Unexpected error: " + e.getMessage());
        }
    }
}