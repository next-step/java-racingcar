package racingcar;

import racingcar.car.Car;
import racingcar.car.CarCollection;

import java.util.List;

public class RacingGameResult {
    private final CarCollection cars;

    public RacingGameResult(List<Car> result) {
        this.cars = new CarCollection(result);
    }

    public int getNumberOfCars() {
        return cars.size();
    }

    public List<Integer> getRecordOfCar(int index) {
        return cars.getRecordOfCar(index);
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public CarCollection getWinners() {
        int max = 0;
        for (Car car : cars.getCars()) {
            max = Math.max(max, car.getFinalRecord());
        }

        return cars.isWin(max);
    }
}
