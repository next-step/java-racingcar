package racing;

import java.util.List;
import java.util.stream.Collectors;

public class Car {

    private final Position position;

    public Car() {
        this.position = new Position();
    }

    public void forward() {
        position.add(1);
    }

    public static List<Position> carPositions(List<Car> cars) {
        return cars.stream()
                .map(car -> car.position)
                .collect(Collectors.toList());
    }

    public boolean hasPosition(int value) {
        return position.equals(new Position(value));
    }
}
