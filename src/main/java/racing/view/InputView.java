package racing.view;

import java.util.Scanner;

public class InputView {

    private static final String NAME_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ROUNDS_QUESTION = "시도할 회수는 몇 회 인가요?";

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String inputRacingCarNames() {
        ResultView.printMessage(NAME_QUESTION);

        return SCANNER.next();
    }

    public static int inputRounds() {
        ResultView.printMessage(ROUNDS_QUESTION);

        return SCANNER.nextInt();
    }
}
