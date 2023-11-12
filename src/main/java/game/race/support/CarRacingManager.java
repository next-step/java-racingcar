package game.race.support;

import java.util.List;

import game.race.Car;
import game.race.dto.RaceDto;
import game.race.support.move.MovePolicy;
import game.race.support.move.impl.RandomPolicy;
import game.race.view.ResultView;

public class CarRacingManager {

    public void start(RaceDto raceDto) {
        ResultView resultView = new ResultView();
        MovePolicy policy = new RandomPolicy();
        // MovePolicy policy = new WeatherPolicy();
        List<Car> cars = Cars.of(raceDto.getVehicleNames(), policy);

        resultView.showPrompt();
        for (int trial = 0; trial < raceDto.getTryCnt(); trial++) {
            for (Car car : cars) {
                car.move(policy.getMoveCount(RandomPolicy.getPolicyNumber()));
                //car.move(policy.getMoveCount(WeatherPolicy.WINDY));
            }

            resultView.showCars(raceDto, cars);

            int lastTrialIndex = raceDto.getTryCnt() - 1;
            if (trial == lastTrialIndex) {
                resultView.print(Cars.getWinners());
            }
        }
    }
}
