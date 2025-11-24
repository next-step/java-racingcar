package ui;

import java.util.Scanner;

public class InputView {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String CAR_MOVE_COUNT_INPUT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    static public String getCarNames() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
        return scanner.nextLine();
    }

    static public int getTryCount() {
        System.out.println(CAR_MOVE_COUNT_INPUT_MESSAGE);
        return scanner.nextInt();
    }
}
