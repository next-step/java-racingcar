package step5.controller;

import step5.model.Car;
import step5.model.CarRacingPlay;

import java.util.List;
import java.util.stream.Collectors;

public class CarRacingController {

    private final CarRacingPlay carRacingPlay;

    public CarRacingController(CarRacingPlay carRacingPlay) {
        this.carRacingPlay = carRacingPlay;
    }

    public void makeRacingCarList(String inputCarNames) {
        List<String> carNames = extractCarNames(inputCarNames);
        carRacingPlay.makeRacingCars(carNames);
    }

    public RacingResultDto race(int racingCycle) {
        RacingResultDto racingResultDto = new RacingResultDto();

        for (int cycle = 1; cycle <= racingCycle; cycle++) {
            List<Car> cars = carRacingPlay.raceOneCycle();
            List<Car> copyCars = cars.stream()
                    .map(Car::deepCopy)
                    .collect(Collectors.toList());
            racingResultDto.racingResult.put(cycle, copyCars);
        }

        return racingResultDto;
    }

    public ChampionCarsDto findChampions() {
        return carRacingPlay.findChampions();
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
}
