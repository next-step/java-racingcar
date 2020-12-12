package racing.domain;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Cars {
    private static final String NAME_SEPARATOR = ",";
    private static final int MAX_BOUND = 10;
    private static final Random random = new Random();
    private final List<Car> cars;

    public Cars(String names) {
        this.cars = Arrays.stream(names.split(NAME_SEPARATOR))
                .map(Car::new)
                .collect(toList());
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void run() {
        for(Car car: cars) {
            car.move(getRandomNum());
        }
    }

    private RandomNumber getRandomNum() {
        return new RandomNumber(random.nextInt(MAX_BOUND));
    }

    public List<Car> getCars() {
        return cars;
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for(Car car: cars) {
            maxPosition = car.max(maxPosition);
        }
        return maxPosition;
    }

    public Cars findWinner() {
        int maxPosition = getMaxPosition();
        List<Car> winners = cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .collect(Collectors.toList());
        return new Cars(winners);
    }

    public String getNames() {
        return cars.stream()
                .map(it -> it.getName().toString()).collect(Collectors.joining(NAME_SEPARATOR));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cars that = (Cars) o;

        return Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return cars != null ? cars.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "cars=" + cars +
                '}';
    }
}
