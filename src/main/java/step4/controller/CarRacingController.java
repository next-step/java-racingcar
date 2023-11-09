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
        this.carRacingPlay = new CarRacingPlay(new MyRandomValueGenerator(), extractCarNames(inputDto.getCarNames()));
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


    private List<String> extractCarNames(String carNames) {
        String[] carNameArray = carNames.split(",");

        for (String carName : carNameArray) {
            checkCarNameLength(carName);
        }
        
        return List.of(carNameArray);
    }

    private void checkCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new RuntimeException("자동차 이름은 5글자를 초과하면 안됩니다.");
        }
    }

    public CarRacingPlay getCarRacingPlay() {
        return carRacingPlay;
    }

    public int getCarRacingChance() {
        return carRacingChance;
    }
}
