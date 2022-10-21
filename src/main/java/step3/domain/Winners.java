package step3.domain;

import java.util.ArrayList;
import java.util.List;
import test2.Positive;

public class Winners {

    public static List<Car> findWinners(List<Car> cars) {
        Position maxPosition = getMaxPosition(cars);
        return getWinners(cars, maxPosition);
    }

    public static Position getMaxPosition(List<Car> cars) {
        Position maxPosition = new Position(0);
        for(Car car : cars) {
            if(maxPosition.currentPosition() < car.currentPosition().currentPosition()) {
                maxPosition = car.currentPosition();
            }
        }
        return maxPosition;
    }

    public static List<Car> getWinners(List<Car> cars, Position maxPosition) {
        List<Car> winners = new ArrayList<>();
        for(Car car : cars) {
            if(maxPosition == car.currentPosition()) {
                winners.add(car);
            }
        }
        return winners;
    }
}
