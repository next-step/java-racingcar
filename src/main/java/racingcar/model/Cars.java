package racingcar.model;

import racingcar.util.NumberCreator;

import java.util.*;

import static racingcar.model.enums.Status.FORWARD;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;// NOTE: 내부에서 변경해야 하므로 여기서 불변객체를 선언하면 안됨
    }

    public static Cars newInstance(final Car... cars) {
        return new Cars(Arrays.asList(cars)) ;
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

    public void moveAllByNumberCreator(NumberCreator numberCreator) {
        this.cars
                .forEach(car -> car.move(numberCreator));
    }

    public List<Car> currentCars() {
        //NOTE: 외부에서는 변경할수 없으므로 여기서 불변객체로 리턴
        return Collections.unmodifiableList(this.cars);
    }

    public int maxForwardCount() {
        return this.cars.stream().mapToInt(Car::currentForwardCount).max().orElseGet(() -> 0);
    }

}
