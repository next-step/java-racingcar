package step3.util;

import java.util.Scanner;

public class InputView {

    private final String CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private final String GAME_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int enterCarCount() {
        return enterCount(CAR_COUNT_MESSAGE);
    }

    public int enterGameCount() {
        int count = enterCount(GAME_COUNT_MESSAGE);
        scanner.close();
        return count;
    }

    private int enterCount(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }


}
