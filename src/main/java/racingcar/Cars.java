package racingcar;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;
    private List<Car> winnerCars;

    private Cars(List<Car> cars) {
        this.cars = cars;
        this.winnerCars = null;
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    public String getWinnerCarNames() {
        return getWinnerCars().stream().map(Car::getName).collect(Collectors.joining(", "));
    }

    private List<Car> getWinnerCars() {
        if (this.winnerCars != null) {
            return this.winnerCars;
        }
        int maxPosition = getMaxPosition(this.cars);
        return this.cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalStateException::new);
    }

    public String getRaceStatusString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            stringBuilder.append(car.getName()).append(" : ").append("-".repeat(car.getPosition())).append('\n');
        }
        return stringBuilder.toString();
    }

    public void moveAll(Random random) {
        for (Car car : cars) {
            car.move(random);
        }
    }
}
