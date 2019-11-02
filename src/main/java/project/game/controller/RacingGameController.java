package project.game.controller;

import project.game.domain.GameType;
import project.game.domain.RacingGame;
import project.game.view.RacingGameView;

import java.util.List;

public class RacingGameController {

    private RacingGameView mView;
    private RacingGame mRacingGame;

    public RacingGameController(RacingGameView view, GameType gameType) {
        this.mView = view;
        mRacingGame = new RacingGame(gameType);
    }

    public void startRacing() {
        mView.showStartGameMessage();

        List<String> carNames = mView.readCarNames();
        mRacingGame.createCars(carNames);

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
