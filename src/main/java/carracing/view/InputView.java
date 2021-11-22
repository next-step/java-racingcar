package carracing.view;

import java.util.Scanner;

public class InputView {
    private static final String QUESTION_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String QUESTION_TRY_COUNT = "시도할 회수는 몇 회 인가요?";

    private final Scanner scanner = new Scanner(System.in);

    public String carNameQuestion() {
        System.out.println(QUESTION_CAR_NAMES);
        return scanner.nextLine();
    }

    public String tryCountQuestion() {
        System.out.println(QUESTION_TRY_COUNT);
        return scanner.nextLine();
    }
}
