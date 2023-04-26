package basicgame;


import basicgame.controller.GameController;
import basicgame.service.strategy.RandomActive;
import basicgame.view.InputView;

public class BasicGame {

    public static void main(String args[]) {

        InputView.printCarInput();
        var carString = InputView.stringInput();

        InputView.printTryInput();
        var tryCount = InputView.intInput();

        GameController gameController = new GameController();

        gameController.startGame(carString, tryCount, new RandomActive());
    }
}
