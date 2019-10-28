package project.game;

public class Main {
    private static final String RACING_GAME_START_TEXT = "레이싱 시작!";
    private static final String CAR_COUNT_INPUT_FORM_TEXT = "자동차 대수는 몇 대 인가요?";
    private static final String ROUND_COUNT_INPUT_FORM_TEXT = "시도할 회수는 몇 회 인가요?";
    private static final String INPUT_FORMAT_ERROR = "숫자만 입력할 수 있습니다. 다시 입력해주세요. Error : %s";
    private static final String RACING_GAME_END_TEXT = "레이싱 종료!";

    public static void main(String[] args) {
        View view = new ConsoleView();

        view.drawText(RACING_GAME_START_TEXT);

        int carCount;
        int roundCount;

        try {
            view.drawText(CAR_COUNT_INPUT_FORM_TEXT);
            carCount = view.readInputToInt();

            view.drawText(ROUND_COUNT_INPUT_FORM_TEXT);
            roundCount = view.readInputToInt();
        } catch (NumberFormatException exception) {
            view.drawText(String.format(INPUT_FORMAT_ERROR, exception.getMessage()));
            return;
        }

        RacingGameNotifier notifier = carPositions -> {
            view.drawNewLine();

            for (Integer carPosition : carPositions) {
                view.drawCharSequence(carPosition, RacingGame.CAR_POSITION_TEXT);
            }
        };
        RacingGame racingGame = new RacingGame(notifier);
        racingGame.start(GameType.RANDOM, carCount, roundCount);

        view.drawText(RACING_GAME_END_TEXT);
    }

}
