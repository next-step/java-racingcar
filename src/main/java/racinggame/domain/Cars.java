package racinggame.domain;

import racinggame.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {
    private final List<Car> cars;

    public Cars(String carNames) {
        this(createCars(carNames));
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    private static List<Car> createCars(String carNames) {
        if (StringUtils.isBlank(carNames)) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        }
        String[] names = carNames.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void race() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public Winners findWinners() {
        return new Winners(findWinners(getMaxPosition()));
    }

    private List<Car> findWinners(int maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : this.cars) {
            if (car.isMaxPosition(maxPosition)) {
                winners.add(car);
            }
        }
        return winners;
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : this.cars) {
            maxPosition = car.max(maxPosition);
        }
        return maxPosition;
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
        return Objects.hashCode(cars);
    }

    @Override
    public String toString() {
        return "Cars{" +
                "cars=" + cars +
                '}';
    }
}
