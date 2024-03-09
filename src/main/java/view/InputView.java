package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    public int askNumberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");

        try {
            return toInt(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return askNumberOfCars();
    }

    public int askRacingTurn() {
        System.out.println("시도할 회수는 몇 회 인가요?");

        try {
            return toInt(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return askRacingTurn();
    }

    private int toInt(String input) {
        int value = Integer.parseInt(input);

        assertOneOrMore(value);

        return value;
    }

    private void assertOneOrMore(int value) {
        if (value < 1) {
            throw new IllegalArgumentException("1 이상의 수를 입력하세요");
        }
    }
}
