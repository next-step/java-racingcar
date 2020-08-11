package core;

import view.InputView;

public class Main {

    public static void main(String args[]) {
        InputView.getInputValue();
        RacingGame racingGame = new RacingGame();
        racingGame.startGame();
    }
}
