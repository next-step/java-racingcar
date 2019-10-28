package project.game;

import project.InputTool;

import java.util.List;

public class RacingGameConsoleView implements RacingGameView {

    private static final String INPUT_FORMAT_ERROR = "숫자만 입력할 수 있습니다. 다시 입력해주세요. Error : %s";

    private static final String CAR_COUNT_INPUT_FORM_TEXT = "자동차 대수는 몇 대 인가요?";
    private static final String ROUND_COUNT_INPUT_FORM_TEXT = "시도할 회수는 몇 회 인가요?";
    private static final String RACING_GAME_START_TEXT = "레이싱 시작!";
    private static final String RACING_GAME_END_TEXT = "레이싱 종료!";

    private static final char CAR_POSITION_TEXT = '-';

    private InputTool mInputTool;
    private RacingGameController mController;

    public RacingGameConsoleView() {
        mInputTool = new InputTool();
    }

    @Override
    public void setController(RacingGameController controller) {
        mController = controller;
    }

    @Override
    public void onStartGame() {
        if (mController == null) {
            return;
        }

        int carCount;
        int roundCount;

        try {
            carCount = readInput(CAR_COUNT_INPUT_FORM_TEXT);
            roundCount = readInput(ROUND_COUNT_INPUT_FORM_TEXT);
        } catch (NumberFormatException exception) {
            drawText(String.format(INPUT_FORMAT_ERROR, exception.getMessage()));
            return;
        }

        drawText(RACING_GAME_START_TEXT);
        mController.startGame(carCount, roundCount);
    }

    @Override
    public void onEndGame() {
        drawText(RACING_GAME_END_TEXT);
    }

    @Override
    public void onCarPositionsChange(List<Integer> carPositions) {
        drawNewLine();

        for (Integer each : carPositions) {
            drawCarPosition(each);
        }
    }

    private int readInput(String title) throws NumberFormatException {
        drawText(title);
        return mInputTool.readLineToInt();
    }

    private void drawNewLine() {
        drawText(System.lineSeparator());
    }

    private void drawCarPosition(int position) {
        StringBuilder positionTextBuilder = new StringBuilder();

        for (int i = 0; i < position; i++) {
            positionTextBuilder.append(CAR_POSITION_TEXT);
        }

        drawText(positionTextBuilder.toString());
    }

    private void drawText(String string) {
        System.out.println(string);
    }
}
