package project.game;

import project.InputTool;

import java.util.List;
import java.util.Scanner;

public class RacingGameViewImpl implements RacingGameView {

    private static final String CAR_COUNT_INPUT_FORM_TEXT = "자동차 대수는 몇 대 인가요?";
    private static final String ROUND_COUNT_INPUT_FORM_TEXT = "시도할 회수는 몇 회 인가요?";
    private static final String RACING_GAME_START_TEXT = "레이싱 시작!";
    private static final String RACING_GAME_END_TEXT = "레이싱 종료!";
    private static final String NEW_LINE_TEXT = "\n";
    private static final char CAR_POSITION_TEXT = '-';

    private InputTool mInputTool;
    private RacingGameController mController;

    public RacingGameViewImpl() {
        mInputTool = new InputTool(new Scanner(System.in));
    }

    @Override
    public void setController(RacingGameController controller) {
        mController = mController;
    }

    @Override
    public void onStartGame() {
        drawText(CAR_COUNT_INPUT_FORM_TEXT);
        drawText(ROUND_COUNT_INPUT_FORM_TEXT);

        mController.startGame();
        drawText(RACING_GAME_START_TEXT);
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

    private void drawNewLine() {
        drawText(NEW_LINE_TEXT);
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
