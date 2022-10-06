package racing.view;

import java.util.Scanner;

public class RacingGameInputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static GameInput record() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        final int playerCount = SCANNER.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요?");
        final int trialCount = SCANNER.nextInt();

        return new GameInput(playerCount, trialCount);
    }
}
