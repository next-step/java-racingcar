package step6.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {
    private static final String CAR_NAMES_DELIMITER = ",";
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final Random rd = new Random();
    private final List<Car> cars;

    protected Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String inputCarName) {
        this.cars = validCarNames(Arrays.asList(inputCarName.split(CAR_NAMES_DELIMITER)));
    }

    private List<Car> validCarNames(List<String> carNames) {
        return carNames.stream()
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
    }

    public void runRacingGame(TryNumber tryNumber) {
        cars.stream()
                .forEach(car -> car.move(getRandomNumber()));
    }

    private int getRandomNumber() {
        return rd.nextInt(MAX_RANDOM_NUMBER) + 1;
    }

    public List<Car> getCars() {
        return cars;
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
