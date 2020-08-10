package racing.view;

import java.util.Scanner;

public class InputView {
    private static final int MIN_INPUT_VALUE = 1;
    private static final String QUESTION_NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요?";
    private static final String INVALID_NUMBER_OF_CARS = "자동차 대수를 최소 1대 이상 입력 하세요.";
    private static final String QUESTION_NUMBER_OF_ATTEMPT = "시도할 횟수는 몇 회 인가요?";
    private static final String INVALID_NUMBER_OF_ATTEMPT = "시도할 횟수를 최소 1회 이상 입력 하세요.";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int getNumberOfCars() {
        System.out.println(QUESTION_NUMBER_OF_CARS);
        final int numberOfCars = scanner.nextInt();

        if(!validNumberOfCars(numberOfCars)) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_CARS);
        }

        return numberOfCars;
    }

    public static boolean validNumberOfCars(final int numberOfCars) {
        return numberOfCars > MIN_INPUT_VALUE;
    }

    public static int getNumberOfAttempt() {
        System.out.println(QUESTION_NUMBER_OF_ATTEMPT);
        final int numberOfAttempt = scanner.nextInt();

        if(!validNumberOfAttempt(numberOfAttempt)) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_ATTEMPT);
        }

        return numberOfAttempt;
    }

    public static boolean validNumberOfAttempt(final int numberOfAttempt) {
        return numberOfAttempt > MIN_INPUT_VALUE;
    }
}
