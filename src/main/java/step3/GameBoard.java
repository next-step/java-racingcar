package step3;

public class GameBoard {
    private final static InputView INPUT_VIEW = InputView.getInstance();
    private final String QUESTION_CAR_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private final String QUESTION_TRIAL_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    private final String RESULT_MESSAGE = "\n실행 결과";
    private final String UNIT_OF_MOVE = "-";

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

    public void renderRaceProgress(Count position) {
        int count = position.getCount();

        render(appendText(count));
    }

    public void renderResultMessage() {
        render(RESULT_MESSAGE);
    }

    private String appendText(int count) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < count; ++i) {
            sb.append(UNIT_OF_MOVE);
        }

        return sb.toString();
    }
}
