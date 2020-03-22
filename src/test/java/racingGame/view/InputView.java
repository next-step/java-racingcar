package racingGame.view;

import java.util.Scanner;

public class InputView {

    private static final String PARTICIPATE_REQUEST = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String GAME_COUNT_REQUEST = "시도할 회수는 몇 회 인가요?";

    private Scanner scanner = new Scanner(System.in);
    private String participates;
    private int gameCount;

    public void execute() {
        participates = receiveParticipates();
        gameCount = receiveGameCount();
    }

    private String receiveParticipates() {
        System.out.println(PARTICIPATE_REQUEST);
        return scanner.nextLine();
    }

    private int receiveGameCount() {
        System.out.println(GAME_COUNT_REQUEST);
        return scanner.nextInt();
    }

    public int getGameCount() {
        return gameCount;
    }

    public String getParticipates() {
        return participates;
    }
}
