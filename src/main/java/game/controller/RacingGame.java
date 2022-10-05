package game.controller;

import game.controller.dto.GameParam;
import game.model.Cars;
import game.view.InputView;
import game.view.OutputView;

import static game.model.Movable.getMovableStrategy;

public class RacingGame {

    public void play() {
        GameParam param = InputView.getGameParam();
        Cars cars = new Cars(param.getCarNames());
        OutputView.printOutputStart();
        for (int i = 0; i < param.getCountOfRound(); i++) {
            playRound(cars);
        }
        OutputView.printOutputResult(cars);
    }

    private static void playRound(Cars cars) {
        cars.moveCarList(getMovableStrategy());
        OutputView.printOutputBody(cars);
    }

}
