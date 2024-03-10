package view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String INVALID_INPUT_MESSAGE_FORMAT = "잘못된 입력값입니다. 다시 입력해주세요. %s";

    private static int numberOfCar;
    private static int countOfTrial;

    public static List<Integer> requestInput() {
        requestCars();
        requestCountOfTrial();
        return List.of(numberOfCar, countOfTrial);
    }

    private static void requestCountOfTrial() {
        try {
            System.out.println("시도할 회수는 몇 회 인가요?");
            countOfTrial = inputNumber();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            requestCountOfTrial();
        }
    }

    private static void requestCars() {
        try {
            System.out.println("자동차 대수는 몇 대 인가요?");
            numberOfCar = inputNumber();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            requestCars();
        }
    }

    private static int inputNumber() {
        try {
            Scanner scanner = new Scanner(System.in);
            String value = scanner.nextLine();
            isValidNumber(value);
            return Integer.parseInt(value);
        } catch (RuntimeException e) {
            throw e;
        }
    }
    private static void isValidNumber(String value) {
        try {
            Integer.parseInt(value);
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException(String.format(INVALID_INPUT_MESSAGE_FORMAT, value));
        }
    }
}
