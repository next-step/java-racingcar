package edu.next.racing.controller;

import edu.next.racing.domain.RacingGame;
import edu.next.racing.view.InputView;
import edu.next.racing.view.ResultView;


public class RacingController {

    private RacingGame game ;
    private InputView inputView;
    private ResultView resultView;

    public RacingController() {
        inputView = new InputView();
        game = new RacingGame(inputView.displayInputStringUi(),
                inputView.displayGameTimeInputUi());
    }

    public void play() {
        resultView = new ResultView(game.execute(),
                game.getTime(),
                game.getWinner());
    }

    public void displayResult() {
        resultView.displayResult();
    }

}
