package racingcar.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_COUNT = "시도할 회수는 몇 회 인가요?";

    public static String getCarNames() {
        return printQuestion(CAR_NAME);
    }

    public static String getTryCount() {
        return printQuestion(TRY_COUNT);
    }

    private static String printQuestion(String message) {
        System.out.println(message);
        return SCANNER.nextLine();
    }
}
