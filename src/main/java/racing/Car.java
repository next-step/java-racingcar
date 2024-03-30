package racing;

import java.util.List;
import java.util.stream.Collectors;

public class Car {

    private static final int GO_CONDITION = 4;

    private final Position position;
    private final Name name;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public static List<Car> findWinners(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        return cars.stream()
                .filter(car -> car.isEqual(maxPosition))
                .collect(Collectors.toList());
    }

    private boolean isEqual(int maxPosition) {
        return position.isEqual(maxPosition);
    }

    private static int findMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public void move(int randomNumber) {
        if (randomNumber >= GO_CONDITION) {
            position.increase();
        }
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
    }
}
