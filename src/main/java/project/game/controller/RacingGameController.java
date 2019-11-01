package project.game.controller;

import project.game.StringUtils;
import project.game.domain.GameType;
import project.game.domain.RacingGame;
import project.game.view.View;

import java.util.List;

import static project.game.TextConstant.*;

public class RacingGameController {

    private static final int INVALID_ROUND_COUNT = -1;
    private static final String SPACE_TEXT = " ";
    private static final String EMPTY_TEXT = "";

    private View mView;
    private RacingGame mRacingGame;

    public RacingGameController(View view) {
        this.mView = view;
        this.mRacingGame = new RacingGame();
    }

    // start 를 통해 시작할경우 동적으로 게임 타입을 바꿀 수 있고 시작할 수 있는 시점을 컨트롤할 수 있다.
    // 이 방식에 단점은 무엇일까? 생성자 초기화 vs set 초기화
    public void start(GameType gameType) {
        mView.drawText(RACING_GAME_START_TEXT);

        initializeCars(gameType);
        startRacing();
    }

    private void initializeCars(GameType gameType) {
        List<String> carNames = getCarNames();
        mRacingGame.setNewGame(gameType, carNames);
    }

    private List<String> getCarNames() {
        String rawCarNamesText = readInput(CAR_NAME_INPUT_FORM_TEXT);
        return StringUtils.splitStringToList(rawCarNamesText.replace(SPACE_TEXT, EMPTY_TEXT), COMMA_DELIMITER);

    }

    private void startRacing() {
        int roundCount;

        try {
            roundCount = getRoundCount();
        } catch (NumberFormatException exception) {
            mView.drawText(INPUT_FORMAT_ERROR);
            return;
        }

        for (int i = 0; i < roundCount; i++) {
            showCurrentCarPositions(mRacingGame.moveCars());
        }

        showWinners();
    }

    private int getRoundCount() {
        return Integer.parseInt(readInput(ROUND_COUNT_INPUT_FORM_TEXT));
    }

    private String readInput(String question) {
        mView.drawText(question);
        return mView.readInput();
    }

    private void showWinners() {
        String winnersText = String.join(COMMA_DELIMITER, mRacingGame.getWinners());
        mView.drawText(String.format(RACING_GAME_WINNERS, winnersText));
    }

    private void showCurrentCarPositions(List<String> currentPositions) {
        mView.drawNewLine();

        for (String each : currentPositions) {
            mView.drawText(each);
        }
    }
}
