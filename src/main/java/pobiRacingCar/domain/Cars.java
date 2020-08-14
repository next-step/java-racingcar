package pobiRacingCar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars; //input cars 외 추가 x final

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> findWinners() {
        int maxPosition = getMaxPosition( );

        return filterWinners(maxPosition);
    }

    private List<Car> filterWinners(int maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            Position position = car.getPosition();
            if (position.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            Position position = car.getPosition();
            if (maxPosition < position.getPosition()) {
                maxPosition = position.getPosition();
            }
        }
        return maxPosition;
    }
}
