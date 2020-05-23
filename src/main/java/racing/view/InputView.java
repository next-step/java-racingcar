package racing.view;

import java.util.Scanner;

public class InputView {
    private final int numberOfCar;
    private final int attempt;

    private final static Scanner SCANNER = new Scanner(System.in);

    private InputView(int numberOfCar, int attempt) {
        this.numberOfCar = numberOfCar;
        this.attempt = attempt;
    }

    public static InputView enterInput() {
        return new InputView(enterNumberOfCar(), enterAttempt());
    }

    private static int enterNumberOfCar() {
        System.out.println("자동차의 대수를 입력 하세요.");
        return SCANNER.nextInt();
    }

    private static int enterAttempt() {
        System.out.println("시도 횟수를 입력하세요.");
        return SCANNER.nextInt();
    }

    public int getNumberOfCar() {
        return numberOfCar;
    }

    public int getAttempt() {
        return attempt;
    }
}
