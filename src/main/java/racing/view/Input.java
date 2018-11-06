package racing.view;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public abstract class Input {

    private static final Scanner scanner = new Scanner(System.in, String.valueOf(StandardCharsets.UTF_8));

    private Input() {
    }

    public static int IntegerQuestion(final String question) {
        printQuestion(question);
        return scanner.nextInt();
    }

    public static String StringQuestion(final String question) {
        printQuestion(question);
        return scanner.nextLine();
    }

    private static void printQuestion(final String question) {
        System.out.println(question);
    }

}
