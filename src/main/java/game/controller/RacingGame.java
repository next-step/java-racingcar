package game.controller;

import game.controller.dto.GameParam;
import game.model.Cars;
import game.model.MovableStrategy;
import game.view.InputView;
import game.view.OutputView;
import utils.RandomNumberUtils;

public class RacingGame {
    public static final int STANDARD_TO_MOVE = 4;

    public void play() {
        GameParam param = InputView.getGameParam();
        Cars cars = new Cars(param.getCountOfCar());
        for (int i = 0; i < param.getCountOfRound(); i++) {
            playRound(cars);
        }
    }

    private static void playRound(Cars cars) {
        cars.moveCarList(getMovableStrategy());
        OutputView.print(cars);
    }

    private static MovableStrategy getMovableStrategy() {
        return () -> RandomNumberUtils.getRandomNumber(10) >= STANDARD_TO_MOVE;
    }
}
