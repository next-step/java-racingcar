package racing.view;

import java.util.Scanner;

/*
 *
 * InputView
 *
 * @version 1.0.0
 *
 * 2021-11-11
 *
 * Copyright tnals1422
 */
public class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public Integer inputCarCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();
    }

    public Integer inputRoundCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return scanner.nextInt();
    }

}
