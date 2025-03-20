package step4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;
    private final MovingStrategy movingStrategy;

    public Cars(String[] carNames, MovingStrategy movingStrategy) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(new CarName(carName)));
        }
        this.cars = cars;
        this.movingStrategy = movingStrategy;
    }

    public Cars(List<Car> cars, MovingStrategy movingStrategy) {
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

    public List<String> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException("There is no Car"));

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }
}
