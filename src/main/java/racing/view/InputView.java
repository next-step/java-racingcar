package racing.view;

import java.util.Scanner;

public class InputView {
    protected static final String CAR_COUNT_QUESTION = "자동차 대수는 몇 대 인가요?";
    protected static final String GAME_COUNT_QUESTION = "시도할 횟수는 몇 회 인가요?";
    private static final Scanner scanner = new Scanner(System.in);

    static int generateCarCountQuestion() {
        System.out.println(CAR_COUNT_QUESTION);
        return scanner.nextInt();
    }

    static int generateGameCountQuestion() {
        System.out.println(GAME_COUNT_QUESTION);
        return scanner.nextInt();
    }
}
