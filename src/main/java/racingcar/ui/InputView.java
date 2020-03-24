package racingcar.ui;

import java.util.Scanner;

public class InputView {

    private int numberOfCars;
    private int tryCount;

    public InputView() {
        this.numberOfCars = inputNumberOfCars();
        this.tryCount = inputTryCount();
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getTryCount() {
        return tryCount;
    }

    private int inputNumberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return getUserInput();
    }

    private int inputTryCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return getUserInput();
    }

    private int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
