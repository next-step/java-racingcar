package step4;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;
    private final MovingStrategy movingStrategy;

    public Cars(String[] carNames, MovingStrategy movingStrategy) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        this.cars = cars;
        this.movingStrategy = movingStrategy;
    }

    public void moveAll() {
        cars.forEach(car -> car.move(movingStrategy));
    }

    public StringBuilder getCurrentStatus() {
        StringBuilder sb = new StringBuilder();
        cars.forEach(car -> sb.append(car.getCurrentStatus()).append("\n"));
        return sb;
    }
}
