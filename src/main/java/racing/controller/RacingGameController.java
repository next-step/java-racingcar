package racing.controller;

import racing.model.DefaultCar;
import racing.service.RacingGameSerice;
import racing.util.RandomGenerator;
import racing.model.Car;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGameController {

    public void start() {
        String[] names = InputView.getCarNames();
        int count = InputView.getGameCount();
        RacingGameSerice racingGameSerice = new RacingGameSerice(names);

        ResultView.printResultTitle();
        for(int i = 0; i < count; i++) {
            ResultView.printRace(racingGameSerice.race());
        }

        ResultView.printWinner(racingGameSerice.getWinner());
    }
}
