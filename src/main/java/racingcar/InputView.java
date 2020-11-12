package racingcar;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    private final String QUESTION_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final String QUESTION_TRY_NUMBERS = "시도할 회수는 몇 회 인가요?";
    private final String CAR_NAMES_DELIMITER = ",";

    public String[] carNames() {
        System.out.println(QUESTION_CAR_NAMES);
        return scanner.nextLine().split(CAR_NAMES_DELIMITER);
    }

    public int tryCount() {
        System.out.println(QUESTION_TRY_NUMBERS);
        return scanner.nextInt();
    }

}
