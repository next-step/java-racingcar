package step3;

import java.util.Scanner;

public class InputView {

    public static final String ASK_MSG_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final String ASK_MSG_RACING_COUNT = "시도할 회수는 몇 회 인가요?";
    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int askRacingCount() {
        System.out.println(ASK_MSG_RACING_COUNT);
        return scanner.nextInt();
    }

    public String askCarName() {
        System.out.println(ASK_MSG_CAR_NAME);
        return scanner.nextLine();
    }
}
