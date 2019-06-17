package racing;

import java.util.Scanner;

public class Prompter {
    static public int getPrompt(String message) {
        System.out.println(message);

        return getInput();
    }

    static private int getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
