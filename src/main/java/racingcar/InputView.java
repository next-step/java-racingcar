package racingcar;

import java.util.Scanner;

public class InputView {

    private int carAmount;
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public void inputCarAmount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        this.carAmount = scanner.nextInt();
    }
}
