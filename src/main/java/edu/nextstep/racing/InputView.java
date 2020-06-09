package edu.nextstep.racing;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String[] splitCarName() {
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            throw new IllegalArgumentException("input data is empty");
        }
        return input.split(",");
    }

    public static int inputer() {
        int number = scanner.nextInt();

        return number;
    }
}
