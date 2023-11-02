package step3;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String MESSAGE_ASK_NUMBER_OF_CARS = "자동차 대수는 몇 대 인가요?";

    private int numberOfCars;

    public void inputNumberOfCars() {
        System.out.println(MESSAGE_ASK_NUMBER_OF_CARS);
        numberOfCars = scanner.nextInt();
    }

    public int numberOfCars() {
        return numberOfCars;
    }

}
