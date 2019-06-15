package step2.racing.ui;

import step2.racing.exception.ScanException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private int carCount;
    private int attemptingTimes;

    private final Scanner scanner = new Scanner(System.in);

    private static final String ASK_CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String ASK_ATTEMPTING_TIMES_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public int askCarCount() {

        System.out.println(ASK_CAR_COUNT_MESSAGE);
        return scanIntValue();
    }

    public int askAttemptingTimes() {

        System.out.println(ASK_ATTEMPTING_TIMES_MESSAGE);
        return scanIntValue();
    }

    private int scanIntValue() {

        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        } catch (Exception e) {
            throw new ScanException("입력 도중 에러가 발생했습니다", e);
        }
    }
}
