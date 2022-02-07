package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private final List<Car> cars;
    private final List<Car> winners = new ArrayList<>();

    public Winner(List<Car> car) {
        this.cars = new ArrayList<>(car);
    }

    public int getMaxScore() {
        int maximum = 0;
        for (Car car: cars) {
            maximum = Math.max(maximum, car.getDistance());
        }
        return maximum;
    }

    public void setWinners() {
        int maximum = getMaxScore();
        for (Car car: cars) {
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
