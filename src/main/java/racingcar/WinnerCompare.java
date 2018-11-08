package racingcar;

import racingcar.domain.Car;

import java.util.Comparator;

public class WinnerCompare implements Comparator<Car> {
    @Override
    public int compare(Car car1, Car car2) {
        return Integer.compare(car1.getPosition(), car2.getPosition());
    }
}
