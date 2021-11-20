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

    public String[] inputName() { return SCANNER.next().split(","); }

    public void carInputPrompt() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void lapInputPrompt() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }
}
