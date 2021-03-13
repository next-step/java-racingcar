package racingcar.model;

import racingcar.module.RandomStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(int playCarNum) {
        cars = generateCars(playCarNum);
    }

    private List<Car> generateCars(int tryNum) {
        List<Car> carList = new ArrayList<>();
        for (int num = 0; num < tryNum; num++) {
            carList.add(new Car());
        }
        return carList;
    }

    public void playCarGame() {
        for (Car car : cars) {
            car.move(new RandomStrategy());
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
