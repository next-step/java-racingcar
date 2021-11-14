package step3;

import step3.controller.GameController;
import step3.domain.movingstrategy.RandomMovingStrategy;
import step3.domain.value.Input;
import step3.view.InputView;
import step3.view.LocationView;

public class SimpleCarRacingGame {
    public static void main(String[] args) {
        InputView view = new InputView();
        view.render();
        Input input = view.readInput();

        new GameController(new LocationView(), new RandomMovingStrategy()).run(input);
    }
}
