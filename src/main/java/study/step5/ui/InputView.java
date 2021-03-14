package study.step5.ui;

import java.util.Scanner;

public class InputView {
    private final static String MESSAGE_INPUT_ROUND = "시도할 회수는 몇 회 인가요?";
    private final static String  MESSAGE_INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final static Scanner scanner = new Scanner(System.in);

    public static int inputRound() {
        System.out.println(MESSAGE_INPUT_ROUND);
        return scanner.nextInt();
    }

    public static String inputCarNames() {
        System.out.println(MESSAGE_INPUT_CAR_NAMES);
        return scanner.nextLine();
    }
}
