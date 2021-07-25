package racing.view;

import java.util.Scanner;

public class InputView {
    private static final String RACING_CAR_COUNT_INPUT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String MOVEMENT_TRIAL_COUNT_INPUT_MESSAGE = "시도할 횟수는 몇 회 인가요?";

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public void printRacingCarCountInputMessage() {
        System.out.println(RACING_CAR_COUNT_INPUT_MESSAGE);
    }

    public int inputRacingCarCount() {
        return scanner.nextInt();
    }

    public void printMovementTrialCountInputMessage() {
        System.out.println(MOVEMENT_TRIAL_COUNT_INPUT_MESSAGE);
    }

    public int inputMovementTrialCount() {
        return scanner.nextInt();
    }
}
