package carrace.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RaceTrack {
    private final List<Car> carList = new ArrayList<>();
    private final RacingRule racingRule;

    public RaceTrack(RacingRule racingRule, int carCount) {
        this.racingRule = racingRule;
        this.carList.addAll(CarFactory.makeCars(carCount));
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
}
