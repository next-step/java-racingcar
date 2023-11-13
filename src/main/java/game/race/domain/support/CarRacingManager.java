package game.race.domain.support;

import java.util.List;

import game.race.domain.support.move.MovePolicy;
import game.race.domain.support.move.impl.RandomPolicy;
import game.race.view.ResultView;

public class CarRacingManager {

    public List<String> start(int tryCnt, List<String> vehicleNames) {
        ResultView resultView = new ResultView();
        MovePolicy policy = new RandomPolicy();
        Cars cars = Cars.of(vehicleNames);

        resultView.showPrompt();

        for (int trial = 0; trial < tryCnt; trial++) {
            cars.move(policy);
            resultView.showCars(vehicleNames, cars.getCarList());
        }

       return cars.getWinners();
    }
}
