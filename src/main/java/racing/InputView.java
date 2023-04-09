package racing;

import java.util.Scanner;

public class InputView {
    private static final int MIN_NUMBER_CARS = 1;
    private static final int MAX_NUMBER_CARS = 10;
    private static final int MIN_NUMBER_CYCLES = 1;
    private static final int MAX_NUMBER_CYCLES = 20;

    private final Scanner scanner = new Scanner(System.in);

    public int readNumberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        String input = scanner.nextLine();
        int number = parseInput(input);
        checkNumberOfCars(number);
        return number;
    }

    public int readNumberOfCycles() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        String input = scanner.nextLine();
        int number = parseInput(input);
        checkNumberOfCycles(number);
        return number;
    }

    private static void checkNumberOfCars(int number) {
        checkRangeOfInput(number, MIN_NUMBER_CARS, MAX_NUMBER_CARS, "자동차 수");
    }

    private static void checkNumberOfCycles(int number) {
        checkRangeOfInput(number, MIN_NUMBER_CYCLES, MAX_NUMBER_CYCLES, "사이클 수");
    }

    private static void checkRangeOfInput(int input, int min, int max, String targetName) {
        if (input > max || input < min) {
            throw new IllegalArgumentException(
                    targetName + "는 " + min + "~" + max + " 사이의 값을 입력해야 합니다. " + input);
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
