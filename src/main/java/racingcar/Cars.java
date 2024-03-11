package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> carList;

    public Cars(int size) {
        this.carList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            this.carList.add(new Car());
        }
    }

    public void move() {
        moveAllCar();
    }

    private void moveAllCar() {
        for (Car car : this.carList) {
            car.move(RandomValueGenerator.generate());
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : this.carList) {
            stringBuilder.append(car.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    public int size() {
        return carList.size();
    }
}
