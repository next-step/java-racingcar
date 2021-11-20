package carracing.view;

import java.util.Scanner;

public class InputView {
    private static final String QUESTION_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String QUESTION_TRY_COUNT = "시도할 회수는 몇 회 인가요?";

    private final Scanner scanner = new Scanner(System.in);

    private String carNames;
    private String tryCount;

    public void carNameQuestion() {
        System.out.println(QUESTION_CAR_NAMES);
        this.carNames = scanner.nextLine();
    }

    public void tryCountQuestion() {
        System.out.println(QUESTION_TRY_COUNT);
        this.tryCount = scanner.nextLine();
    }

    public String getCarNames() {
        return carNames;
    }

    public String getTryCount() {
        return tryCount;
    }
}
