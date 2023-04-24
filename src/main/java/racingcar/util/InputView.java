package racingcar.util;

import java.util.Scanner;

public class InputView {

    private static final String REQUEST_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String REQUEST_TRY_NUMBER = "시도할 회수는 몇 회인가요?";

    public static String receiveCarNumber(Scanner scanner) {
        questionCarNumber();
        return scanner.nextLine();
    }

    public static int receiveTryNumber(Scanner scanner) {
        questionTryNumber();
        return scanner.nextInt();
    }

    private static void questionCarNumber() {
        System.out.println(REQUEST_CAR_NAMES);
    }

    private static void questionTryNumber() {
        System.out.println(REQUEST_TRY_NUMBER);
    }

}
