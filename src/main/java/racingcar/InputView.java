package racingcar;

import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int getNumberOfCars() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int numberOfCars = scanner.nextInt();

        return numberOfCars;
    }

    public int getTryCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();

        return tryCount;
    }
}
