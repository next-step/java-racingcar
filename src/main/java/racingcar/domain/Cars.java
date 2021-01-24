package racingcar.domain;

import racingcar.utils.RankPicker;
import racingcar.utils.RankPickerImpl;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();
    private final RankPicker rankPicker = new RankPickerImpl();

    public void addAll(List<Car> newCars) {
        cars.addAll(newCars);
    }

    public List<Car> getList() {
        return cars;
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> pickTopRankers() {
        return rankPicker.pickTopRankers(cars);
    }
}