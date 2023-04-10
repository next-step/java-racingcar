package racingcar;

import java.util.Scanner;

public class InputView {

    private int carAmount;
    private int tryAmount;
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public void inputCarAmount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        this.carAmount = scanner.nextInt();
    }

    public void inputTryAmount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        this.tryAmount = scanner.nextInt();
    }

    public int getCarAmount() {
        return carAmount;
    }

    public int getTryAmount() {
        return tryAmount;
    }
}
