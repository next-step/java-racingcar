package racing.domain.car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racing.domain.generator.DefaultNumberGenerator;
import racing.domain.generator.NumberGenerator;

public class CarRace {

    private static int MOVE_NUMBER = 4;

    private final List<Car> cars;
    private final NumberGenerator numberGenerator;

    public CarRace(List<Car> cars, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public CarRace(List<Car> cars) {
        this.cars = cars;
        this.numberGenerator = new DefaultNumberGenerator();
    }

    public CarRace(int count) {
        this(makeCars(count));
    }

    public int size() {
        return cars.size();
    }

    private static List<Car> makeCars(int count) {
        return IntStream.range(0, count)
            .mapToObj(Car::new)
            .collect(Collectors.toList());
    }

    public List<Car> cars() {
        return new ArrayList<>(cars);
    }

    public CarRace move() {
        List<Car> carList = cars.stream()
            .map(car -> move(car, numberGenerator))
            .collect(Collectors.toList());
        return new CarRace(carList);
    }

    private Car move(Car car, NumberGenerator numberGenerator) {
        if (numberGenerator.randomNumber() < MOVE_NUMBER) {
            return car;
        }
        return car.move();
    }
}
