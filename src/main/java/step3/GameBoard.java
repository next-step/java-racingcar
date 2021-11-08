package step3;

import java.io.StringReader;

public class GameBoard {
    private final static InputView INPUT_VIEW = InputView.getInstance();
    private final String QUESTION_CAR_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private final String QUESTION_TRIAL_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private final String RESULT_MESSAGE = "\n실행 결과";
    private final String UNIT_OF_MOVE = "-";

    public Count registerCar() {
        System.out.println(QUESTION_CAR_MESSAGE);

        return INPUT_VIEW.inputValue();
    }

    public Count registerTrialCount() {
        System.out.println(QUESTION_TRIAL_COUNT_MESSAGE);

        return INPUT_VIEW.inputValue();
    }

    public void drawRaceProgress(Count moveCount) {
        int count = moveCount.getCount();

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < count ; ++i) {
            sb.append(UNIT_OF_MOVE);
        }

        System.out.println(sb.toString());
    }

    public void resultMessage() {
        System.out.println(RESULT_MESSAGE);
    }
}
