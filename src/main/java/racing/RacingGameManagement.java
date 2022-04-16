package racing;

import racing.exception.RacingException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RacingGameManagement {
    private final Map<Car, CarDrivingTypes> racingCarManagement;

    public RacingGameManagement(Map<Car, CarDrivingTypes> racingCarManagement) {
        this.racingCarManagement = racingCarManagement;
    }

    public void addDrivingStatus(Car car, CarDrivingType carDriving) {
        CarDrivingTypes byCar = findDrivingTypes(car);
        byCar.add(carDriving);
    }

    public CarDrivingTypes findDrivingTypes(Car car) {
        CarDrivingTypes carDrivingTypes = racingCarManagement.get(car);

        if (carDrivingTypes != null) {
            return carDrivingTypes;
        }

        throw new RacingException("carName: " + car.getCarName() + " 이(가) 존재하지 않습니다.");
    }

    public WinnerRacingCars findWinners() {
        List<Car> cars = new ArrayList<>();
        int topMovingCount = 0;

        for (Map.Entry<Car, CarDrivingTypes> next : racingCarManagement.entrySet()) {
            int laps = next.getValue().getGoMovingCount();
            topMovingCount = setWinnerCars(cars, topMovingCount, next, laps);
        }

        return new WinnerRacingCars(new RacingCars(cars));
    }

    private int setWinnerCars(List<Car> winnerCars, int topMovingCount, Map.Entry<Car, CarDrivingTypes> next, int laps) {
        if (topMovingCount == next.getValue().getGoMovingCount()) {
            winnerCars.add(next.getKey());
            return topMovingCount;
        }

        if (topMovingCount < laps) {
            winnerCars.clear();
            winnerCars.add(next.getKey());
            return laps;
        }

        return topMovingCount;
    }

}
