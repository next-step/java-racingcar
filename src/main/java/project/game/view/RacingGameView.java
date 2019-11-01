package project.game.view;

import project.InputTool;
import project.game.StringUtils;

import java.util.List;

import static project.game.TextConstant.*;

public class RacingGameView {

    private static final String ROUND_COUNT_INPUT_FORM_TEXT = "시도할 회수는 몇 회 인가요?";
    private static final String CAR_NAME_INPUT_FORM_TEXT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_FORMAT_ERROR = "숫자만 입력할 수 있습니다. 다시 입력해주세요.";
    private static final String RACING_GAME_START_TEXT = "레이싱 시작!";
    private static final String RACING_GAME_WINNERS = "%s 가 최종 우승했습니다.";

    private InputTool mInputTool;

    public RacingGameView() {
        mInputTool = new InputTool();
    }

    public void showCarPositions(List<String> carPositions) {
        drawNewLine();

        for (String each : carPositions) {
            drawText(each);
        }
    }

    public List<String> readCarNames() {
        drawText(CAR_NAME_INPUT_FORM_TEXT);
        String rawCarNamesText = readLine();
        return StringUtils.splitStringToList(rawCarNamesText.replace(SPACE_TEXT, EMPTY_TEXT), COMMA_DELIMITER);
    }

    public int readRoundCount() {
        drawText(ROUND_COUNT_INPUT_FORM_TEXT);
        return Integer.parseInt(readLine());
    }

    public void showInvalidNumberErrorMessage() {
        drawText(INPUT_FORMAT_ERROR);
    }

    public void showStartGameMessage() {
        drawText(RACING_GAME_START_TEXT);
    }

    public void showWinners(List<String> winners) {
        String winnersText = String.join(COMMA_DELIMITER, winners);
        drawText(String.format(RACING_GAME_WINNERS, winnersText));
    }

    private void drawNewLine() {
        drawText(System.lineSeparator());
    }

    private void drawText(String string) {
        System.out.println(string);
    }

    private String readLine() {
        return mInputTool.readLine();
    }
}
