package racing;

import java.util.Scanner;

public class InputView {

    private static final String NUMBER_OF_CARS = "자동차 대수는 몇 대인가요?";
    private static final String NUMBER_OF_ATTEMPTS = "시도할 횟수는 몇 회인가요?";

    public static RacingGame initializeGame(Scanner scanner) {
        int numberOfCars = inputFromUser(NUMBER_OF_CARS, scanner);
        int numberOfAttempts = inputFromUser(NUMBER_OF_ATTEMPTS, scanner);
        return new RacingGame(numberOfCars, numberOfAttempts);
    }

    private static int inputFromUser(String requestMessage, Scanner scanner) {
        print(requestMessage);
        return inputNumber(scanner);
    }

    private static void print(String message) {
        System.out.println(message);
    }

    private static int inputNumber(Scanner scanner) {
        return scanner.nextInt();
    }
}
