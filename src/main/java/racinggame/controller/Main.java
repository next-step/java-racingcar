package racinggame.controller;

import racinggame.domain.*;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class Main {
    public static void main(String[] args) {
        InputView.displayCarInput();
        String carNameString = InputView.getNextString();

        InputView.displayRoundInput();
        int gameRound = InputView.getUserInputToInt();

        MoveDecider moveDecider = new RandomDecider();

        RacingGameParameters racingGameParameters = new RacingGameParameters(gameRound, carNameString, moveDecider);
        RacingGame racingGame = new RacingGame(racingGameParameters);

        GameResults gameResults = racingGame.playFullRound();

        ResultView.displayResult(gameResults);
    }
}
