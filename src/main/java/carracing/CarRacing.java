package carracing;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {
    List<Car> cars;

    public CarRacing(List<Car> cars) {
        this.cars = cars;
    }

    private int calculateWinnerPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    public List<String> makeWinners() {
        List<String> winners = new ArrayList<String>();
        int winnerPosition = calculateWinnerPosition();
        for (Car car : cars) {
            if (winnerPosition == car.getPosition()) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }
}