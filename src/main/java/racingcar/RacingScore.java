package racingcar;

import racingcar.car.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingScore {
    private List<Car> cars;
    private int maxPosition;

    public RacingScore(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public List<Car> getScore() {
        return new ArrayList<>(cars);
    }

    public List<Car> getWinner() {
        getMaxPosition();
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            addWinners(winners, car);
        }

        return new ArrayList<>(winners);
    }

    private void addWinners(List<Car> winners, Car car) {
        if (car.getPosition() == maxPosition) {
            winners.add(car);
        }
    }

    private void getMaxPosition() {
        for (Car car : cars) {
            maxPosition = comparePosition(maxPosition, car);
        }
    }

    private int comparePosition(int position, Car car) {
        if (position < car.getPosition()) {
            position = car.getPosition();
        }
        return position;
    }
}
