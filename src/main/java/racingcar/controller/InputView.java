package racingcar.controller;

import java.util.Scanner;

public class InputView {

    public static final Scanner scanner = new Scanner(System.in);
    private static InputView INSTANCE = null;

    private InputView() {

    }

    public static InputView getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new InputView();
        }
        return INSTANCE;
    }

    public int getCarNumber() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();

    }

    public int getMatchNumber() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
