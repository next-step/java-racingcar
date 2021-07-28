package racing.view;

import java.util.Scanner;

public class InputView {
    private static final String RACING_CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String MOVEMENT_TRIAL_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회 인가요?";
    private static final String RACING_CAR_NAMES_DELIMITER = ",";

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public void printRacingCarNamesInputMessage() {
        System.out.println(RACING_CAR_NAMES_INPUT_MESSAGE);
    }

    public String[] inputRacingCarNames() {
        return scanner.nextLine().split(RACING_CAR_NAMES_DELIMITER);
    }

    public void printMovementTrialCountInputMessage() {
        System.out.println(MOVEMENT_TRIAL_COUNT_INPUT_MESSAGE);
    }

    public int inputMovementTrialCount() {
        return scanner.nextInt();
    }
}
