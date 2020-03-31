package racingcar;

import racingcar.car.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingGameResult {
    private final List<Car> result;

    public RacingGameResult(List<Car> result) {
        this.result = new ArrayList<>(result);
    }

    public int getNumberOfCars() {
        return result.size();
    }

    public List<Integer> getRecordOfCar(int index) {
        return result.get(index).getRecord();
    }

    public List<Car> getRecords() {
        return new ArrayList<>(result);
    }
}
