package carrace.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RaceTrack {
    private final List<Car> carList = new ArrayList<>();
    private final RandomRacingRule racingRule = new RandomRacingRule();

    public RaceTrack(int carCount) {
        this.carList.addAll(CarFactory.makeCars(carCount));
    }

    public RaceTrack(Car... cars) {
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
