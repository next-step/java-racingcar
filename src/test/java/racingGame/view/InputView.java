package racingGame.view;

import java.util.Scanner;

public class InputView {

    private static final String PARTICIPATE_REQUEST = "자동차 대수는 몇 대 인가요?";
    private static final String GAME_COUNT_REQUEST = "시도할 회수는 몇 회 인가요?";

    private Scanner scanner = new Scanner(System.in);
    private int participateCount;
    private int gameCount;

    public void execute() {
        participateCount = receiveParticipateCount();
        gameCount = receiveGameCount();
    }

    private int receiveParticipateCount() {
        System.out.println(PARTICIPATE_REQUEST);
        return scanInt();
    }

    private int receiveGameCount() {
        System.out.println(GAME_COUNT_REQUEST);
        return scanInt();
    }

    private int scanInt() {
        return scanner.nextInt();
    }

    public int getParticipateCount() {
        return participateCount;
    }

    public int getGameCount() {
        return gameCount;
    }
}
