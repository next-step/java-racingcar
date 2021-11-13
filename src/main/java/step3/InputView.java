package step3;

import java.util.Scanner;

public class InputView {

    private final String ASK_MSG_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    private final String ASK_MSG_RACING_COUNT = "시도할 회수는 몇 회 인가요?";
    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int askCarCount() {
        System.out.println(ASK_MSG_CAR_COUNT);
        return scanner.nextInt();
    }

    public int askRacingCount() {
        System.out.println(ASK_MSG_RACING_COUNT);
        return scanner.nextInt();
    }
}
