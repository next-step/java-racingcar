package racingcar.ui;

import java.util.Scanner;

public class RacingCarInputView {

    private static final RacingCarInputView RACING_CAR_INPUT_VIEW = new RacingCarInputView();

    private static final Scanner SCANNER = new Scanner(System.in);

    private RacingCarInputView() {
    }

    public static RacingCarInputView getInstance() {
        return RACING_CAR_INPUT_VIEW;
    }

    public int input() {
        return SCANNER.nextInt();
    }

    public void carInputPrompt() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public void lapInputPrompt() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }
}
