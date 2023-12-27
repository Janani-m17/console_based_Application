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
        englishToMorse.put('A', ".-");
        englishToMorse.put('B', "-...");
        englishToMorse.put('C', "-.-.");
        englishToMorse.put('D', "-..");
        englishToMorse.put('E', ".");
        englishToMorse.put('F', "..-.");
        englishToMorse.put('G', "--.");
        englishToMorse.put('H', "....");
        englishToMorse.put('I', "..");
        englishToMorse.put('J', ".---");
        englishToMorse.put('K', "-.-");
        englishToMorse.put('L', ".-..");
        englishToMorse.put('M', "--");
        englishToMorse.put('N', "-.");
        englishToMorse.put('O', "---");
        englishToMorse.put('P', ".--.");
        englishToMorse.put('Q', "--.-");
        englishToMorse.put('R', ".-.");
        englishToMorse.put('S', "...");
        englishToMorse.put('T', "-");
        englishToMorse.put('U', "..-");
        englishToMorse.put('V', "...-");
        englishToMorse.put('W', ".--");
        englishToMorse.put('X', "-..-");
        englishToMorse.put('Y', "-.--");
        englishToMorse.put('Z', "--..");

        englishToMorse.put('0', "-----");
        englishToMorse.put('1', ".----");
        englishToMorse.put('2', "..---");
        englishToMorse.put('3', "...--");
        englishToMorse.put('4', "....-");
        englishToMorse.put('5', ".....");
        englishToMorse.put('6', "-....");
        englishToMorse.put('7', "--...");
        englishToMorse.put('8', "---..");
        englishToMorse.put('9', "----.");

        englishToMorse.put('.', ".-.-.-");
        englishToMorse.put(',', "--..--");
        englishToMorse.put('?', "..--..");
        englishToMorse.put('\'', ".----.");
        englishToMorse.put('!', "-.-.--");
        englishToMorse.put('/', "-..-.");
        englishToMorse.put('(', "-.--.");
        englishToMorse.put(')', "-.--.-");
        englishToMorse.put('&', ".-...");
        englishToMorse.put(':', "---...");
        englishToMorse.put(';', "-.-.-.");
        englishToMorse.put('=', "-...-");
        englishToMorse.put('+', ".-.-.");
        englishToMorse.put('-', "-....-");
        englishToMorse.put('_', "..--.-");
        englishToMorse.put('"', ".-..-.");
        englishToMorse.put('$', "...-..-");
        englishToMorse.put('@', ".--.-.");
        for (Map.Entry<Character, String> entry : englishToMorse.entrySet()) {
            morseToEnglish.put(entry.getValue(), entry.getKey());
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

        while (true) {
            try {
                System.out.println("\nEnter a choice:");
                System.out.println("1. English to Morse Code");
                System.out.println("2. Morse Code to English");
                System.out.println("3. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Enter the English text:");
                        String englishText = scanner.nextLine();
                        System.out.println("Morse Code: " + translator.textToMorse(englishText));
                        break;
                    case 2:
                        System.out.println("Enter the Morse Code (use spaces between characters and 2 spaces between words):");
                        String morseCode = scanner.nextLine();
                        System.out.println("English Text: " + translator.morseToText(morseCode));
                        break;
                    case 3:
                        System.out.println("Exit");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }
}
