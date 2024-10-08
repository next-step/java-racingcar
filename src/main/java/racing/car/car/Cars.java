package racing.car.car;

import racing.car.random.Random;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public int max() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.max(maxPosition);
        }
        return maxPosition;
    }

    public void initialize(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void move(Random random) {
        for (Car car : cars) {
            car.move(random.random());
        }
    }

    public List<Car> findWinner(int maxPosition) {
        return cars.stream().filter(car -> car.isSame(maxPosition))
                .collect(Collectors.toList());
    }

    public void draw() {
        for (Car car : cars) {
            car.draw();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
