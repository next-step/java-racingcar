package study.step3.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final String REQUEST_MESSAGE_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    private static final String REQUEST_MESSAGE_TRY_ROUND = "시도할 회수는 몇 회 인가요?";
    private static final String EXCEPTION_MESSAGE_ILLEGAL_ARGUMENT = "입력 문자열이 정상적이지 않습니다.";
    private static final Scanner scanner = new Scanner(System.in);

    public int setupCarCount (){
        return requestCarCount();
    }

    public int setupTryRound() {
        return requestTryCount();
    }

    /**
     * 차량 대수 요청
     * @return int type 차량 대수
     */
    private int requestCarCount() {
        System.out.println(REQUEST_MESSAGE_CAR_COUNT);
        return getInt();
    }

    /**
     * 시도 횟수 요청
     * @return int type 시도 횟수
     */
    private int requestTryCount() {
        System.out.println(REQUEST_MESSAGE_TRY_ROUND);
        return getInt();
    }

    /**
     * 입력값 int 형식 치환
     * @return int
     */
    private int getInt(){
        try {
            return scanner.nextInt();
        } catch(InputMismatchException exception) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_ILLEGAL_ARGUMENT);
        }
    }

}
