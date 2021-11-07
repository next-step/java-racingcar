package step3.view;

import step3.domain.Participant;

public class ResultView {

    private static final String GAME_START_OUTPUT_MESSAGE = "실행 결과";

    public static void start() {
        System.out.println(GAME_START_OUTPUT_MESSAGE);
    }

    public static void result(Participant participant) {
        participant.showPosition();
        System.out.println();
    }
}
