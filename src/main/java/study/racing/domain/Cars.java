package study.racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {

    private static final int DEFAULT_POSITION = 1;
    private static final int RANDOM_RANGE = 10;
    private static final String NEXT_LINE = "\n";
    private final List<Car> value;

    public Cars(CarsNumber carsNumber) {

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < carsNumber.getValue(); i++) {
            cars.add(new Car(new Position(DEFAULT_POSITION)));
        }

        this.value = cars;
    }

    public String move(NumberGenerator randomGenerator, TryCounts tryCounts) {

        StringBuilder positionBuilder = new StringBuilder();

        for (int i = 0; i < tryCounts.getValue(); i++) {
            positionBuilder.append(moveEachCar(randomGenerator));
            positionBuilder.append(NEXT_LINE);
        }

        return positionBuilder.toString();
    }

    private String moveEachCar(NumberGenerator randomGenerator) {

        StringBuilder positionBuilder = new StringBuilder();

        for (Car car : value) {
            String dash = car.move(randomGenerator.random(RANDOM_RANGE));
            positionBuilder.append(dash).append(NEXT_LINE);
        }

        return positionBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return Objects.equals(value, cars.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
