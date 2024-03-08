package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String ASK_NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요?";
    private static final String ASK_RACING_TURN = "시도할 회수는 몇 회 인가요?";
    private static final String INVALID_INPUT = "1이상의 수를 입력하세요";
    private static final int ONE = 1;

    public int askNumberOfCars() {
        System.out.println(ASK_NUMBER_OF_CARS);

        int result = 0;
        try {
            result = toInt(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            askNumberOfCars();
        }

        return result;
    }

    public int askRacingTurn() {
        System.out.println(ASK_RACING_TURN);

        int result = 0;
        try {
            result = toInt(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            askRacingTurn();
        }

        return result;
    }


    private int toInt(String input) {
        int value = Integer.parseInt(input);

        assertOneOrMore(value);

        return value;
    }

    private void assertOneOrMore(int value) {
        if (value < ONE) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
    }
}
