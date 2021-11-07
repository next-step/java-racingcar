package step3.view;

import step3.domain.Participant;

public class ResultView {

    private static final String START_OUTPUT_MESSAGE = "실행 결과";

    public static void start() {
        System.out.println(START_OUTPUT_MESSAGE);
    }

    public static void result(Participant participant) {
        participant.showPosition();
        System.out.println();
    }
}
