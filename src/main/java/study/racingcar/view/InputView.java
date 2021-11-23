package study.racingcar.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final String REQUEST_MESSAGE_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String REQUEST_MESSAGE_TRY_ROUND = "시도할 회수는 몇 회 인가요?";
    private static final String EXCEPTION_MESSAGE_ILLEGAL_ARGUMENT = "입력 문자열이 정상적이지 않습니다.";
    private static final Scanner scanner = new Scanner(System.in);

    public static String requestCarNames() {
        System.out.println(REQUEST_MESSAGE_CAR_NAMES);
        return scanner.next();
    }

    public static int requestTryCount() {
        System.out.println(REQUEST_MESSAGE_TRY_ROUND);
        try {
            return scanner.nextInt();
        } catch(InputMismatchException exception) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_ILLEGAL_ARGUMENT);
        }
    }
}
