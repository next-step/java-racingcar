package racingcar.domain;

import racingcar.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {
    private static final String CAR_NAME_REQUIRED_ERROR = "자동차 이름은 값이 존재해야 합니다.";

    private final List<Car> cars;
    List<Integer> positions = new ArrayList<>();

    public Cars(String carNames) {
        cars = createCar(carNames);
    }

    public Cars(List<Car> cars) {
        this(cars, new ArrayList<>());
    }

    public Cars(List<Car> cars, List<Integer> positions) {
        this.cars = cars;
        this.positions = new ArrayList<>(positions);
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public Cars move() {
        List<Car> tempCars = new ArrayList<>();
        List<Integer> tempPosition = new ArrayList<>();
        for (Car car : cars) {
            Car movedCar = car.move();
            tempPosition.add(movedCar.getPosition());
            tempCars.add(movedCar);
        }
        return new Cars(tempCars, tempPosition);
    }

    public List<Integer> getPositions() {
        return new ArrayList<>(positions);
    }

    private List<Car> createCar(String carNames) {
        List<Car> tempCars = new ArrayList<>();

        if (StringUtils.isBlank(carNames)) {
            throw new IllegalArgumentException(CAR_NAME_REQUIRED_ERROR);
        }
        String[] names = carNames.split(",");

        for (String name : names) {
            tempCars.add(new Car(name));
        }
        return tempCars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cars)) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(getCars(), cars1.getCars());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCars());
    }
}
