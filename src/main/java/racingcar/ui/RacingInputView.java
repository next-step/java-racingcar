package racingcar.ui;

import java.util.Scanner;

public class RacingInputView {
    private final Scanner scanner;

    public RacingInputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int carCnt() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public int raceTimes() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
