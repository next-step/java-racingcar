package study.step3.ui;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);
    private static final String CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String GAME_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public void questionCarCount() {
        System.out.println(CAR_COUNT_MESSAGE);
    }

    public void questionGameCount() {
        System.out.println(GAME_COUNT_MESSAGE);
    }

    public int getCount() {
        return this.scanner.nextInt();
    }

}
