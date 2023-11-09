package game.race.support;

import java.util.List;

import game.race.Car;
import game.race.dto.RaceDto;
import game.race.view.ResultView;

public class CarRacingManager {

    public static void start(RaceDto raceDto) {
        ResultView resultView = new ResultView();
        List<Car> cars = Car.getCars(raceDto);

        resultView.showPrompt();
        for (int trial = 0; trial < raceDto.getTryCnt(); trial++) {
            for (Car car : cars) {
                car.move();
            }

            resultView.showCars(raceDto, cars);

            int lastTrialIndex = raceDto.getTryCnt() - 1;
            if (trial == lastTrialIndex) {
                resultView.printWinner(cars);
            }
        }
    }
}
