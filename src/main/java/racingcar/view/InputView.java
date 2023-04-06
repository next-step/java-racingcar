package racingcar.view;

import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    private static final String CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String TRY_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public void gameIntroText() {
        System.out.println(CAR_COUNT_MESSAGE);
        scanner.nextInt();

        System.out.println(TRY_COUNT_MESSAGE);
        scanner.nextInt();
    }
}
