package step4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Car{
    public String name;
    private int distance = 0;

    MoveStrategy moveStrategy = new RandomMoveStrategy();

    public Car() {
    }

    public Car(String carNames) {
        this.name = carNames;
    }
    public Car(int distance) {
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

    public void addDistance() {
        if (moveStrategy.randomNumber() >= 4) {
            distance++;
        }
    }

    public void move() {
        addDistance();
    }

    public int getDistance() {
        return distance;
    }
}

