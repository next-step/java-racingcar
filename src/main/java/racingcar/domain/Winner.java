package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private final Cars cars;
    private final List<Car> winners = new ArrayList<>();

    public Winner(Cars cars) {
        this.cars = cars;
    }

    public int getMaxScore() {
        int maximum = 0;
        for (Car car: cars.getCars()) {
            maximum = Math.max(maximum, car.getDistance());
        }
        return maximum;
    }

    public void setWinners() {
        int maximum = getMaxScore();
        for (Car car: cars.getCars()) {
            if (isWinner(car, maximum)) {
                winners.add(car);
            }
        }
    }

    public boolean isWinner(Car car, int maximum) {
        return car.getDistance() == maximum;
    }

    public List<Car> getWinners() {
        return winners;
    }
}
