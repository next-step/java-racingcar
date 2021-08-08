package racingcar;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Cars {
    private List<Car> cars;

    public Cars (int carNum) {
        cars = new LinkedList<>();
        IntStream.range(0, carNum).forEach(i -> cars.add(new Car()));
    }

    public Cars (Cars carsToBeCopied) {
        cars = new LinkedList<>();
        carsToBeCopied.cars.forEach(car -> this.cars.add(new Car(car)));
    }

    /* 테스트를 위한 생성자 */
    public Cars (Car ... cars) {
        this.cars = new LinkedList<>();
        Arrays.stream(cars).forEach(car-> this.cars.add(car));
    }

    public Cars move(MoveRule moveRule) {
        cars.stream().forEach(car-> car.move(moveRule));
        return this;
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
