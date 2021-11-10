package edu.nextstep.camp.view;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private static final int VALIDATE_NUMBER = 1;

    private final Scanner scanner = new Scanner(System.in);

    public int inputPositiveNumber(String message) {
        System.out.println(message);
        final int number = scanner.nextInt();
        if (number < VALIDATE_NUMBER) {
            throw new IllegalArgumentException("1 이상의 숫자가 필요");
        }

        return number;
    }

    public String[] inputCSV(String message, int limit, String delimiter) {
        System.out.println(message);
        final String value = scanner.nextLine();
        if (value.isEmpty()) {
            throw new IllegalArgumentException("input must not be empty.");
        }

        final String[] split = value.split(delimiter);
        if (Arrays.stream(split)
                .anyMatch(s -> s.length() > limit))
            throw new IllegalArgumentException("value is too long:" + Arrays.toString(split));

        return split;
    }
}
