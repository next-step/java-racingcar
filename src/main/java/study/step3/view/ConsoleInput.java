package study.step3.view;

import java.util.Objects;
import java.util.Scanner;

public class ConsoleInput {

    private static final String NULL_INPUT = "입력값이 null 입니다";
    private static final String NOT_NUMBER = "입력값이 숫자가 아닙니다 -> ";
    private final Scanner scanner = new Scanner(System.in);

    public int getNumber(String question) {
        return parseIntOrThrow(askNumber(question));
    }

    private String askNumber(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    private int parseIntOrThrow(String number) {
        validateNumber(number);
        return Integer.parseInt(number);
    }

    private void validateNumber(String number) {
        requireNonNull(number);
        requireNumber(number);
    }

    private void requireNonNull(String number) {
        if (Objects.isNull(number)) {
            throw new IllegalArgumentException(NULL_INPUT);
        }
    }

    private void requireNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER + number);
        }
    }
}
