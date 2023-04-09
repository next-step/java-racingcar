package racing;

import java.util.Scanner;

public class InputView {
    private static final int MIN_NUMBER_CARS = 1;
    private static final int MAX_NUMBER_CARS = 10;
    private static final int MIN_NUMBER_CYCLES = 1;
    private static final int MAX_NUMBER_CYCLES = 20;

    private final Scanner scanner = new Scanner(System.in);

    public int readNumberOfCars() {
        String input = scanner.nextLine();
        int number = parseInput(input);
        checkNumberOfCars(number);
        return number;
    }

    public int readNumberOfCycles() {
        String input = scanner.nextLine();
        int number = parseInput(input);
        checkNumberOfCycles(number);
        return number;
    }

    private static void checkNumberOfCars(int number) {
        if (number > MAX_NUMBER_CARS || number < MIN_NUMBER_CARS) {
            throw new IllegalArgumentException("자동차 수는 " + MIN_NUMBER_CARS + "~" + MAX_NUMBER_CARS + " 사이의 값을 입력해야 합니다. " + number);
        }
    }

    private static void checkNumberOfCycles(int number) {
        if (number > MAX_NUMBER_CYCLES || number < MIN_NUMBER_CYCLES) {
            throw new IllegalArgumentException("사이클 수는 " + MIN_NUMBER_CYCLES + "~" + MAX_NUMBER_CYCLES + " 사이의 값을 입력해야 합니다. " + number);
        }
    }

    private static int parseInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Input은 정수만 입력 가능합니다. " + input);
        }
    }

}
