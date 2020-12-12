package carrace.domain;

import java.util.*;
import java.util.stream.Collectors;

public class RaceTrack {
    private final List<Car> carList = new ArrayList<>();
    private final RacingRule racingRule;

    public RaceTrack(RacingRule racingRule, int carCount) {
        this.racingRule = racingRule;
        this.carList.addAll(CarFactory.makeCarList(carCount));
    }

    public RaceTrack(RacingRule racingRule, List<CarName> carNames) {
        if (carNames == null) {
            throw new IllegalArgumentException();
        }
        this.racingRule = racingRule;
        this.carList.addAll(CarFactory.makeCarList(carNames));
    }

    public RaceTrack(RacingRule racingRule, Car... cars) {
        this.racingRule = racingRule;
        carList.addAll(Arrays.asList(cars));
    }

    public void next() {
        for (Car car : carList) {
            car.tryToMoveForward(racingRule);
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<Car> getWinner() {
        int max = carList.stream()
                .map(Car::getPosition)
                .max(Integer::compare)
                .orElseThrow(IllegalStateException::new);

        return carList.stream()
                .filter(car -> car.getPosition() == max)
                .collect(Collectors.toList());
    }

}
