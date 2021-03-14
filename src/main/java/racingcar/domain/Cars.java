package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(int carNumber) {
        cars = generateCar(carNumber);
    }

    private List<Car> generateCar(int carNumber) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNumber; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public int getCarsSize() {
        return cars.size();
    }

    public void moveOneCar(int index, Boolean isMove) {
        cars.get(index).move(isMove);
    }

    public List<Car> getCars() {
        return cars;
    }
}


