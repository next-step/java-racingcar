package study.racingcar.view;

import java.util.InputMismatchException;
import java.util.Scanner;

// view는 직접적으로 도메인 객체 노출 X
// controller 통해서 요청
public class InputView {
    private static final String REQUEST_MESSAGE_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String REQUEST_MESSAGE_TRY_ROUND = "시도할 회수는 몇 회 인가요?";
    private static final String EXCEPTION_MESSAGE_ILLEGAL_ARGUMENT = "입력 문자열이 정상적이지 않습니다.";
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * 차량 대수 요청
     * @return int type 차량 대수
     */
    public static String requestCarNames() {
        System.out.println(REQUEST_MESSAGE_CAR_NAMES);
        return scanner.next();
    }

    /**
     * 시도 횟수 요청
     * @return int type 시도 횟수
     */
    public static int requestTryCount() {
        System.out.println(REQUEST_MESSAGE_TRY_ROUND);
        try {
            return scanner.nextInt();
        } catch(InputMismatchException exception) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_ILLEGAL_ARGUMENT);
        }
    }
}
