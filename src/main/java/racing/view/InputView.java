package racing.view;

import java.util.Scanner;

public class InputView {

    private static final String QUESTION_FOR_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String QUESTION_FOR_ATTEMPT_COUNT = "시도할 회수는 몇회인가요?";
    private static final String DELIMITER = ",";

    private static final Scanner scanner = new Scanner(System.in);

    public String[] inputCarNames() {
        System.out.println(QUESTION_FOR_CAR_NAMES);
        return scanner.nextLine().split(DELIMITER);
    }

    public int inputAttemptCount() {
        System.out.println(QUESTION_FOR_ATTEMPT_COUNT);
        return scanner.nextInt();
    }
}
