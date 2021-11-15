package step3;

import java.util.List;

public class GameBoard {
    private static final InputView INPUT_VIEW = InputView.getInstance();
    private final String QUESTION_CAR_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private final String QUESTION_TRIAL_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private final String RESULT_MESSAGE = "\n실행 결과";
    private final String UNIT_OF_MOVE = "-";

    private final int ZERO = 0;

    private final static StringBuilder STRING_BUILDER = new StringBuilder();

    private void render(String text) {
        System.out.println(text);
    }

    public Count registerCar() {
        render(QUESTION_CAR_MESSAGE);

        return INPUT_VIEW.inputValue();
    }

    public Count registerTrialCount() {
        render(QUESTION_TRIAL_COUNT_MESSAGE);

        return INPUT_VIEW.inputValue();
    }

    public void renderRaceResult(List<Record> recordList) {
        recordList.forEach(r -> {
            renderPosition(r);
        });
    }

    private void renderPosition(Record record) {
        record.recordList().stream()
                .forEach(p -> {
                    System.out.println(appendText(p.getPosition()));
                });

        System.out.println();
    }

    public void renderResultMessage() {
        render(RESULT_MESSAGE);
    }

    private String appendText(int count) {
        STRING_BUILDER.setLength(ZERO);

        for(int i = 0; i < count; ++i) {
            STRING_BUILDER.append(UNIT_OF_MOVE);
        }

        return STRING_BUILDER.toString();
    }
}
