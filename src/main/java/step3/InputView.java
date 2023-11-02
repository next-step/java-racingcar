package step3;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String MESSAGE_ASK_NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요?";
    private static final String MESSAGE_ASK_NUMBER_OF_TRY = "시도할 회수는 몇 회 인가요?";

    private int numberOfCars;
    private int numberOfTry;

    public void inputNumberOfCars() {
        System.out.println(MESSAGE_ASK_NUMBER_OF_CARS);
        numberOfCars = scanner.nextInt();
    }

    public void inputNumberOfTry() {
        System.out.println(MESSAGE_ASK_NUMBER_OF_TRY);
        numberOfTry = scanner.nextInt();
    }

    public int numberOfCars() {
        return numberOfCars;
    }

    public int numberOfTry() {
        return numberOfTry;
    }

}
