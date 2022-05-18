package racingcar.view;

import java.util.Scanner;

public class InputView {
    private InputView() {

    }

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_ATTEMPT_COUNT = "시도할 회수는 몇 회 인가요?";
    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    public static String inputCarName() {
        System.out.println(INPUT_CAR_NAME);
        return SCANNER.nextLine();
    }
    
    public static int inputAttemptCount() {
        System.out.println(INPUT_ATTEMPT_COUNT);
        return SCANNER.nextInt();
    }
}
