package study.step3.ui;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputCount(String message) {
        System.out.println(message);
        return Integer.parseInt(scanner.nextLine());
    }
}

