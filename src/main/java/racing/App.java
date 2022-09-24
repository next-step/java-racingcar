package racing;

import java.util.Scanner;

public class App {

    private static final String REQUEST_NUMBER_OF_CARS = "자동차 대수는 몇 대인가요?";
    private static final String REQUEST_NUMBER_OF_ATTEMPTS = "시도할 횟수는 몇 회인가요?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeGame(scanner);
    }

    private static void initializeGame(Scanner scanner) {
        int numberOfCars = inputFromUser(REQUEST_NUMBER_OF_CARS, scanner);
        int numberOfAttempts = inputFromUser(REQUEST_NUMBER_OF_ATTEMPTS, scanner);
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
