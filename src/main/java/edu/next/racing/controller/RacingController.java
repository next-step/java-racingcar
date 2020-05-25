package edu.next.racing.controller;

import edu.next.racing.domain.RacingGame;
import edu.next.racing.view.InputView;
import edu.next.racing.view.ResultView;


public class RacingController {

    RacingGame game;
    InputView inputView;
    ResultView resultView;

    public void initalize() {
        this.game = new RacingGame(inputView.displayInputStringUi(),
                inputView.displayGameTimeInputUi());
    }

    public void play() {
        this.resultView = new ResultView(game.execute(),
                game.getTime(),
                game.getWinner());
    }

    public void displayResult() {
        resultView.displayResult();
    }

}
