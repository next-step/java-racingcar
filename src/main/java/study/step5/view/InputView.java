package study.step5.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String CAR_INPUT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ATTEMPT_INPUT = "시도할 회수는 몇 회 인가요?";
    private static final String CAR_NAME_DELIMITER = ",";

    private InputView() {
    }

    public static String[] inputCarNames() {
        System.out.println(CAR_INPUT);
        return scanner.nextLine().split(CAR_NAME_DELIMITER);
    }

    public static int inputAttemptNumber() {
        System.out.println(ATTEMPT_INPUT);
        return scanner.nextInt();
    }
}
