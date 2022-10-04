package carracing;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> names) {
        cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public List<Car> move(MovingStrategy movingStrategy) {
        return cars.stream()
                .map(car -> car.move(movingStrategy))
                .collect(toList());
    }

    public Position findBiggestPosition() {
        return cars.stream()
                .reduce((car, car2) -> car.isFartherThan(car2) ? car : car2)
                .get()
                .getPosition();
    }


    public List<Car> findWinner(Position biggestPosition) {
        return cars.stream()
                .filter(car -> car.getPosition().equals(biggestPosition))
                .collect(toList());
    }
}
