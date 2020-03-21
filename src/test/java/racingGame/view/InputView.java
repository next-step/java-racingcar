package racingGame.view;

import java.util.Scanner;

import static racingGame.view.InputMessage.*;

public class InputView {

    private Scanner scanner = new Scanner(System.in);
    private int participateCount;
    private int gameCount;

    public void execute() {
        participateCount = receiveParticipateCount();
        gameCount = receiveGameCount();
    }

    private int receiveParticipateCount() {
        System.out.println(PARTICIPATE_COUNT.getMessage());
        return scanInt();
    }

    private int receiveGameCount() {
        System.out.println(GAME_COUNT.getMessage());
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
