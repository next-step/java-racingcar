package edu.nextstep.racingcarwinner.domain;

import edu.nextstep.racingcarwinner.strategy.RacingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private final List<Car> racingCars;

    private RacingCars(List<Car> carList) {
        this.racingCars = carList;
    }

    public static RacingCars of(List<Car> carList) {
        return new RacingCars(carList);
    }

    public static RacingCars of(String carNameStr) {
        return RacingCars.of(carNameStr.split(","));
    }

    public static RacingCars of(String[] carNameArr) {
        List<Car> carList = makeCarList(carNameArr);
        return RacingCars.of(carList);
    }

    private static List<Car> makeCarList(String[] carNameArr) {
        List<Car> carList = new ArrayList<>();
        for (String name : carNameArr) {
            carList.add(new Car(name));
        }
        return carList;
    }


    public void move(RacingStrategy racingStrategy) {
        racingCars.forEach(C -> C.move(racingStrategy));
    }

    public List<Car> findWinner() {
        return getWinners(getMaxDistance());
    }

    private List<Car> getWinners(int maxDistance) {

        return racingCars.stream()
                .filter(C -> C.getDistance() == maxDistance)
                .collect(Collectors.toList());
    }

    private int getMaxDistance() {
        int maxDistance = 0;

        for (Car car : racingCars) {
            maxDistance = car.max(maxDistance);
        }

        return maxDistance;
    }

    public List<Car> getRacingCars() {
        return this.racingCars;
    }
}
