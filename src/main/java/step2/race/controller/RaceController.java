package step2.race.controller;

import step2.car.domain.Car;
import step2.car.domain.engine.RandomEngine;
import step2.race.domain.Race;
import step2.race.domain.RaceHistory;
import step2.race.service.RaceService;

import java.util.List;

public class RaceController {

    private static InputView inputView = new InputView(System.in);
    private static OutputView outputView = new OutputView();

    public static void main(String[] args) {
        int carAmount = inputView.inputCarAmount();
        int moveAmount = inputView.inputMoveAmount();

        RaceService raceService = new RaceService();
        List<Car> cars = raceService.makeRacingCars(carAmount, new RandomEngine());
        Race race = new Race(cars);

        raceService.startRacing(race, moveAmount);

        List<RaceHistory> raceHistories = race.getRaceHistories();
        outputView.showResult(raceHistories);
    }

}
