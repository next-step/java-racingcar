package racing.view;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public abstract class Input {

    private static final Scanner scanner = new Scanner(System.in, String.valueOf(StandardCharsets.UTF_8));

    private Input() {
    }

    public static int question(final String question) {
        printQuestion(question);
        return scanner.nextInt();
    }

    private static void printQuestion(final String question) {
        System.out.println(question);
    }

}
