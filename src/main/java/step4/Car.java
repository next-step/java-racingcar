package step4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Car {
    public String name;
    private int distance = 0;

    MoveStrategy moveStrategy = new RandomMoveStrategy();

    public Car() {
    }

    public Car(String carNames) {
        this.name = carNames;
    }

    public Car(String carNames, int distance) {
        this.name = carNames;
        this.distance = distance;
    }

    public List<Car> generateCars(String carNames) {
        return splitCarNames(carNames);
    }

    public static List<Car> splitCarNames(String carNames) {
        return Arrays.stream(carNames.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void move() {
        if (moveStrategy.isMove()) {
            distance++;
        }
    }

    public int getDistance() {
        return distance;
    }

}

