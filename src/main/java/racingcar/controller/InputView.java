package racingcar.controller;

import java.util.Scanner;

public class InputView {

    private static InputView INSTANCE = null;

    private InputView() {

    }

    public static InputView getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new InputView();
        }
        return INSTANCE;
    }

    public void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carNum = scanner.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        int match = scanner.nextInt();
    }
}
