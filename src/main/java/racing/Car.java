package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Car {

    private static final int GO_CONDITION = 4;

    private int position = 0;
    private String name;

    public Car() {
    }

    public Car(String name) {
        if (name.trim().length() > 5) {
            throw new IllegalStateException("자동차 이름은 5자를 초과할 수 없다.");
        }
        this.name = name.trim();
    }

    public Car(String name, int position) {
        this(name);
        this.position = position;
    }

    public static List<Car> findWinners(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private static int findMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(1);
    }

    public void move(int randomNumber) {
        if (randomNumber >= GO_CONDITION) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
