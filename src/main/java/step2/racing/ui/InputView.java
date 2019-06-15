package step2.racing.ui;

import step2.racing.inputter.Inputter;

public class InputView {

    private final Inputter inputter;

    private static final String ASK_CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String ASK_ATTEMPTS_MESSAGE = "시도할 회수는 몇 회 인가요?";

    public InputView(Inputter inputter) {this.inputter = inputter;}

    public int askCarCount() {

        printAskMessage(ASK_CAR_COUNT_MESSAGE);
        return inputter.inputIntValue();
    }

    public int askAttempts() {

        printAskMessage(ASK_ATTEMPTS_MESSAGE);
        return inputter.inputIntValue();
    }

    private void printAskMessage(String message) {

        System.out.println(message);
    }
}
