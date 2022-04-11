package racingcar;

import java.util.Scanner;

public class Prompt {
    private static final Scanner scanner = new Scanner(System.in);

    public static int ask(String question) {
        System.out.println(question);
        return scanner.nextInt();
    }
}
