package step3.view;

import java.util.Scanner;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);
    private int numberOfCars;
    private int numberOfTry;

    private void requestNumberOfCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        numberOfCars = scanner.nextInt();
    }

    private void requestNumberOfTry() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        numberOfTry = scanner.nextInt();
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getNumberOfTry() {
        return numberOfTry;
    }
}
