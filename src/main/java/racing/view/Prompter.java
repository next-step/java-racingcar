package racing.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Prompter {
    static public int getIntPrompt(String message) {
        System.out.println(message);

        return getIntInput();
    }

    static public List<String> getStringsPrompt(String message) {
        System.out.println(message);

        String[] carNames = split(getStringInput());

        return Arrays.asList(carNames);
    }

    static private int getIntInput() {
        return getScanner().nextInt();
    }

    static private String getStringInput() {
        return getScanner().nextLine();
    }

    static private Scanner getScanner() {
        return new Scanner(System.in);
    }

    static private String[] split(String names) {
        return names.split(",");
    }
}
