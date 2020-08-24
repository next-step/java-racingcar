package racingcar.domain;

import racingcar.strategy.DoOneForward;
import racingcar.strategy.OneOrZeroForwardCondition;

import java.util.*;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() >= maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    public void moveCars(List<Car> cars) {
        cars.forEach(o -> o.move(new OneOrZeroForwardCondition(), new DoOneForward()));
    }

    public static List<Car> findWinners(List<Car> cars) {
        List<Car> winnerList = new ArrayList<>( );
        for (Car car : cars) {
            if (car.getPosition( ) == getMaxPosition(cars)) {
                winnerList.add(car);
            }
            if (car.getPosition( ) > getMaxPosition(cars)) {
                winnerList.add(car);
            }
        }
        return winnerList;
    }

    public List<Car> getCars() {
        return cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
