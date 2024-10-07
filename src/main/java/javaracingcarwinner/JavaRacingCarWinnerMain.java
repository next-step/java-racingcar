package javaracingcarwinner;

import javaracingcarwinner.controller.JavaRacingGame;
import javaracingcarwinner.view.InputView;
import javaracingcarwinner.view.ResultView;

public class JavaRacingCarWinnerMain {
    public static void main(String[] args) {

        JavaRacingGame javaRacingGame = new JavaRacingGame(InputView.gameSettings());
        new ResultView(javaRacingGame.endGame());
    }
}
