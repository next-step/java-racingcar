package game.race.support;

import java.util.List;

import game.race.dto.RaceDto;
import game.race.support.move.MovePolicy;
import game.race.support.move.impl.RandomPolicy;
import game.race.view.ResultView;

public class CarRacingManager {

    public List<String> start(RaceDto raceDto) {
        ResultView resultView = new ResultView();
        MovePolicy policy = new RandomPolicy();
        Cars cars = Cars.of(raceDto.getVehicleNames());

        resultView.showPrompt();

        int tryCnt = raceDto.getTryCnt();
        for (int trial = 0; trial < tryCnt; trial++) {
            cars.move(policy);
            resultView.showCars(raceDto, cars.getCarList());
        }

       return cars.getWinners();
    }
}
