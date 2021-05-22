package carracing;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {
    private List<Car> cars;

    public CarRacing(List<Car> cars) {
        this.cars = cars;
    }

    private int calculateWinnerPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public List<Car> makeWinners() {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isMaxPosition(calculateWinnerPosition()) == true) {
                winners.add(car);
            }
        }
        return winners;
    }

    public void moveCars(List<Car> cars, int racingCount) {
        for (int i = 0; i < racingCount; i++) {
            for (Car car : cars) {
                car.move(RandomNumber.createRandomNumber());
            }
        }
    }
}