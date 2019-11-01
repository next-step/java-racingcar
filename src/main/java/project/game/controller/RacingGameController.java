package project.game.controller;

import project.game.domain.GameType;
import project.game.domain.RacingGame;
import project.game.view.RacingGameView;

import java.util.List;

public class RacingGameController {

    private RacingGameView mView;
    private RacingGame mRacingGame;

    public RacingGameController(RacingGameView view) {
        this.mView = view;
        this.mRacingGame = new RacingGame();
    }

    // start 를 통해 시작할경우 동적으로 게임 타입을 바꿀 수 있고 시작할 수 있는 시점을 컨트롤할 수 있다.
    // 이 방식에 단점은 무엇일까? 생성자 초기화 vs set 초기화
    public void start(GameType gameType) {
        mView.showStartGameMessage();

        initializeCars(gameType);
        startRacing();
    }

    private void initializeCars(GameType gameType) {
        List<String> carNames = mView.readCarNames();
        mRacingGame.setNewGame(gameType, carNames);
    }

    private void startRacing() {
        int roundCount;

        try {
            roundCount = mView.readRoundCount();
        } catch (NumberFormatException exception) {
            mView.showInvalidNumberErrorMessage();
            return;
        }

        for (int i = 0; i < roundCount; i++) {
            mView.showCarPositions(mRacingGame.moveCars());
        }

        showWinners();
    }

    private void showWinners() {
        mView.showWinners(mRacingGame.getWinners());
    }
}
