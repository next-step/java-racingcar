package racingcar.domain;

import racingcar.service.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(int carNumber) {
        cars = generateCars(carNumber);
    }

    private List<Car> generateCars(int carNumber) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNumber; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public void moveCars(MoveStrategy moveStrategy) {
        for (int i = 0; i < getSize(); i++) {
            cars.get(i).move(moveStrategy.getIsMove());
        }
    }

    public int getSize() {
        return cars.size();
    }

    public List<Car> getCars() {
        return cars;
    }
}


