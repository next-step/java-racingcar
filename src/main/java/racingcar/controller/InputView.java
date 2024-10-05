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

    public String getRacingCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.next();
    }

    public int getMatchCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
