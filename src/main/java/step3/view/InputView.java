package step3.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String INPUT_ROUND_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";

    Scanner scanner = new Scanner(System.in);

    public int getCarCount() {
        printCarCountMessage();
        return scanner.nextInt();
    }

    private void printCarCountMessage() {
        System.out.println(INPUT_CAR_COUNT_MESSAGE);
    }

    public int getRoundCount() {
        printRoundCountMessage();
        return scanner.nextInt();
    }

    private void printRoundCountMessage() {
        System.out.println(INPUT_ROUND_COUNT_MESSAGE);
    }

}
