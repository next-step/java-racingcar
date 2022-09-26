package racing;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputPositive(String question) {
        System.out.println(question);
        int value = scanner.nextInt();
        if (value < 1) { value = 1; }

        return value;
    }
}
