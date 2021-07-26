package carracing.view;

import java.util.Objects;
import java.util.Scanner;

public class RoundConsoleInput {

    private static final String ROUND_QUESTION = "시도할 회수는 몇 회 인가요?";
    private static final String NULL_INPUT = "입력값이 null 입니다";
    private static final String NOT_NUMBER = "입력값이 숫자가 아닙니다 -> ";
    private final Scanner scanner = new Scanner(System.in);

    public int getNumber() {
        return parseIntOrThrow(askNumber());
    }

    private String askNumber() {
        System.out.println(ROUND_QUESTION);
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
