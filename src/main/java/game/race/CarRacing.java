package game.race;

import game.race.domain.support.Cars;
import game.race.domain.support.move.MovePolicy;
import game.race.domain.support.move.impl.RandomPolicy;
import game.race.dto.RaceDto;
import game.race.view.InputView;
import game.race.view.ResultView;

public class CarRacing {

    public static void main(String[] args) {
        race();
    }

    public static void race() {
        RaceDto raceData = InputView.showPrompt();
        ResultView.showPrompt();

        Cars cars = Cars.of(raceData.getVehicleNames());
        for (int trial = 0; trial < raceData.getTryCnt(); trial++) {
            MovePolicy policy = new RandomPolicy();
            cars.move(policy);

            ResultView.showCars(raceData.getVehicleNames(), cars.getCars());
        }

        ResultView.printWinners(cars.getWinners());
    }
}
