package racingcar;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int inputCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }
}
