package step5.controller;

import step5.model.Car;
import step5.model.CarRacingPlay;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

        LinkedHashMap<Integer, List<Car>> result = IntStream.range(1, racingCycle + 1)
                .boxed()
                .collect(Collectors.toMap(
                        cycle -> cycle,
                        cycle -> carRacingPlay.raceOneCycle()
                                .stream().map(Car::deepCopy)
                                .collect(Collectors.toList()),
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        return new RacingResultDto(result);
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
