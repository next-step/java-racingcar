package racingcar.view;

import java.util.Scanner;

public class InputView {
    private int numberOfCars;
    private int attemptCount;

    public void initGameInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 입니까?");
        this.numberOfCars = scanner.nextInt();

        System.out.println("시도할 횟수는 몇 회 입니까?");
        this.attemptCount = scanner.nextInt();
    }

    public int getNumberOfCars() {
        return this.numberOfCars;
    }

    public int getAttemptCount() {
        return this.attemptCount;
    }
}
