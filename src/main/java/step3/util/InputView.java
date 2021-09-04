package step3.util;

import java.util.Scanner;

public class InputView {

    private static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String GAME_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String enterCarName() {
        System.out.println(CAR_NAME_MESSAGE);
        return scanner.next();
    }

    public int enterGameCount() {
        System.out.println(GAME_COUNT_MESSAGE);

        int count = scanner.nextInt();

        return count;
    }

    public void closeScanner() {
        scanner.close();
    }
}
