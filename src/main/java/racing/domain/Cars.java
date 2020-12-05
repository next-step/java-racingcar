package racing.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    private final PowerGenerator powerGenerator;
    private final List<Car> cars;

    public Cars(int carCount, PowerGenerator powerGenerator) {
        this.cars = Stream.generate(Car::new)
                .limit(carCount)
                .collect(Collectors.toList());

        this.powerGenerator = powerGenerator;
    }

    Cars(List<Car> cars, PowerGenerator powerGenerator) {
        this.cars = cars;
        this.powerGenerator = powerGenerator;
    }

    public void move() {
        cars.forEach(car -> car.move(powerGenerator.generate()));
    }

    public List<Car> getCars() {
        return cars;
    }

    public int size() {
        return cars.size();
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
