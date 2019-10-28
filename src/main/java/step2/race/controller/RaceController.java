package step2.race.controller;

import step2.car.domain.Car;
import step2.car.domain.engine.RandomEngine;
import step2.race.domain.Race;
import step2.race.service.RaceService;

import java.util.List;

public class RaceController {

    private static InputView inputView = new InputView(System.in);
    private static OutputView outputView = new OutputView();

    public static void main(String[] args) {
        List<String> names = inputView.inputCarNames();
        int moveAmount = inputView.inputMoveAmount();

        RaceService raceService = new RaceService();
        List<Car> cars = raceService.makeRacingCars(names, new RandomEngine());
        Race race = new Race(cars);

        raceService.startRacing(race, moveAmount);

        outputView.showResult(race);
    }

}
