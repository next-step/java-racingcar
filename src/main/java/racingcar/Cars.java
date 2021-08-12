package racingcar;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        isValidCarNumber(carNames.size());
        cars = new LinkedList<>();
        carNames.forEach(name -> cars.add(new Car(name)));
    }

    public Cars(Cars carsToBeCopied) {
        cars = new LinkedList<>();
        carsToBeCopied.cars.forEach(car -> this.cars.add(new Car(car)));
    }

    public Cars move(MoveStrategy moveStrategy) {
        cars.forEach(car -> car.move(moveStrategy));
        return this;
    }

    private void isValidCarNumber(int carNum) {
        if (carNum <= 0) {
            throw new IllegalArgumentException("자동차 수는 1 이상의 정수입니다.");
        }
    }

    List<Integer> getCarsPosition() {
        List<Integer> result = new LinkedList<>();
        this.cars.forEach(car -> result.add(car.getCarPosition()));
        return result;
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
