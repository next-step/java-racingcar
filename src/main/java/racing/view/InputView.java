package racing.view;

import java.util.Scanner;

public class InputView {
    private static final int MIN_NUMBER_CARS = 1;
    private static final int MAX_NUMBER_CARS = 10;
    private static final int MIN_NUMBER_CYCLES = 1;
    private static final int MAX_NUMBER_CYCLES = 20;

    public static int readNumberOfCars(Scanner scanner) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int number = parseInput(scanner.nextLine());
        return validateNumberOfCar(number);
    }

    public static int readNumberOfCycles(Scanner scanner) {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int number = parseInput(scanner.nextLine());
        return validateNumberOfCycle(number);
    }

    private static int validateNumberOfCar(int number) {
        if (!isRange(number, MIN_NUMBER_CARS, MAX_NUMBER_CARS)) {
            throw new IllegalArgumentException(
                    "자동차 수는 " + MIN_NUMBER_CARS + "~" + MAX_NUMBER_CARS + " 사이의 값을 입력해야 합니다.");
        }
        return number;
    }

    private static int validateNumberOfCycle(int number) {
        if (!isRange(number, MIN_NUMBER_CYCLES, MAX_NUMBER_CYCLES)) {
            throw new IllegalArgumentException(
                    "사이클 수는 " + MIN_NUMBER_CYCLES + "~" + MAX_NUMBER_CYCLES + " 사이의 값을 입력해야 합니다.");
        }
        return number;
    }

    private static boolean isRange(int input, int min, int max) {
        return (input >= min && input <= max);
    }

    private static int parseInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Input은 정수만 입력 가능합니다. " + input);
        }
    }
}
