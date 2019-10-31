package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Racers {
    private static final int DEFAULT_MAX_POSITION = 0;
    private static final int RACE_MOVE_BOUND = 10;

    private List<Car> cars = new ArrayList<>();

    public Racers(List<Car> cars) {
        this.cars.addAll(cars);
    }

    public void moveAll() {
        for (Car car : cars) {
            car.move(CountGenerator.getRandomInt(RACE_MOVE_BOUND));
        }
    }

    public int size() {
        return cars.size();
    }

    public String getRacerName(int index) {
        return cars.get(index).getName();
    }

    public int getPosition(int index) {
        return cars.get(index).position();
    }

    public List<String> winner() {
        int maxPosition = getMaxPosition();

        return this.cars.stream()
                .filter(car -> car.position() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return this.cars.stream()
                .mapToInt(Car::position)
                .max()
                .orElse(DEFAULT_MAX_POSITION);
    }
}
