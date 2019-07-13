package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private List<Car> winners;
    private static int maxPosition;

    public Winners(List<Car> cars) {
        winners = new ArrayList<>();
        this.winners = findWinner(cars);
    }

    public List<Car> findWinner(List<Car> cars) {
        maxPosition = 0;
        for (Car car : cars) {
            comparePosition(car);
        }
        for (Car car : cars) {
            verifyWinner(car);
        }
        return winners;
    }

    public void comparePosition(Car car) {
        if (car.getPosition() > maxPosition) {
            maxPosition = car.getPosition();
        }
    }

    public void verifyWinner(Car car) {
        if (car.getPosition() == maxPosition) {
            winners.add(car);
        }
    }

    public List<Car> getCars() {
        return winners;
    }
}
