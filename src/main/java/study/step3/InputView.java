package study.step3;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String CAR_INPUT = "자동차 대수는 몇 대 인가요?";
    private static final String ATTEMPT_INPUT = "시도할 회수는 몇 회 인가요?";

    private InputView() {
    }

    public static int inputCarNumber() {
        System.out.println(CAR_INPUT);
        return scanner.nextInt();
    }

    public static int inputAttemptNumber() {
        System.out.println(ATTEMPT_INPUT);
        return scanner.nextInt();
    }
}
