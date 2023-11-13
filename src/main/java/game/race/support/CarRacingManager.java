package game.race.support;

import game.race.dto.RaceDto;
import game.race.support.move.MovePolicy;
import game.race.support.move.impl.RandomPolicy;
import game.race.view.ResultView;

public class CarRacingManager {

    public void start(RaceDto raceDto) {
        ResultView resultView = new ResultView();
        MovePolicy policy = new RandomPolicy();
        Cars cars = new Cars();
        cars.of(raceDto.getVehicleNames());

        resultView.showPrompt();

        int tryCnt = raceDto.getTryCnt();
        for (int trial = 0; trial < tryCnt; trial++) {
            cars.move(policy);
            resultView.showCars(raceDto, cars.getCars());

            findWinner(tryCnt, trial, cars, resultView);
        }
    }

    private static void findWinner(int tryCnt,
                                   int trial,
                                   Cars cars,
                                   ResultView resultView) {
        int lastTrialIndex = tryCnt - 1;
        if (trial == lastTrialIndex) {
            resultView.print(cars.getWinners());
        }
    }
}
