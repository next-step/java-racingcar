package step4.controller;

import step4.model.Car;
import step4.model.CarRacingPlay;
import step4.model.ChampionCarsDto;
import step4.model.MyRandomValueGenerator;
import step4.view.InputDto;
import step4.view.ResultView;

import java.util.List;

public class CarRacingController {

    private CarRacingPlay carRacingPlay;
    private int carRacingChance;

    public CarRacingController(InputDto inputDto) {
        this.carRacingPlay = new CarRacingPlay(new MyRandomValueGenerator(), inputDto.getCarNames());
        carRacingChance = inputDto.getCarRacingChance();
    }

    public void carRacing() {
        ResultView resultView = new ResultView();
        resultView.printRacingResultStartText();

        for (int i = 0; i < carRacingChance; i++) {
            List<Car> cars = carRacingPlay.raceOneCycle();
            resultView.printRacingStatus(cars);
        }

        ChampionCarsDto champions = carRacingPlay.findChampions();
        resultView.printChampionCars(champions);
    }
}
