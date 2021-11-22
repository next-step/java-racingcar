package racinggame;

import racinggame.controller.GameController;
import racinggame.domain.movingstrategy.RandomMovingStrategy;
import racinggame.domain.value.Input;
import racinggame.view.InputView;
import racinggame.view.LocationView;

public class SimpleCarRacingGame {
    public static void main(String[] args) {
        InputView view = new InputView();
        view.render();
        Input input = view.readInput();

        new GameController(new LocationView(), new RandomMovingStrategy()).run(input);
    }
}
