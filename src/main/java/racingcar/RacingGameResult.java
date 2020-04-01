package racingcar;

import racingcar.car.Car;
import racingcar.car.CarCollection;

import java.util.List;

public class RacingGameResult {
    private final CarCollection result;

    public RacingGameResult(List<Car> result) {
        this.result = new CarCollection(result);
    }

    public int getNumberOfCars() {
        return result.size();
    }

    public List<Integer> getRecordOfCar(int index) {
        return result.getRecordOfCar(index);
    }

    public List<Car> getCars() {
        return result.getCars();
    }

    public CarCollection getWinners() {
        int max = 0;
        for (Car car : result.getCars()) {
            Math.max(max, car.getFinalRecord());
        }

        return null;
    }
}
