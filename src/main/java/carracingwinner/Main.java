package carracingwinner;

import carracingwinner.ui.InputView;
import carracingwinner.ui.ResultView;

public class Main {
    public static void main(String[] args) {
        CarRacingGame game = new CarRacingGame(new InputView(), new ResultView());
        game.start();
    }
}
