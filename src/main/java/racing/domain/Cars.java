package racing.domain;

import racing.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public void add(Car car) {
        cars.add(car);
    }

    public int size() {
        return cars.size();
    }

    public void race() {
        for (Car car : cars) {
            car.move(RandomGenerator.generate());
        }
    }

    public int getWinnerPosition(List<Car> cars) {
        int winnerPosition = 0;
        for (Car car : cars) {
            winnerPosition = Math.max(car.getPosition(), winnerPosition);
        }
        return winnerPosition;
    }

    public RacingRecord getLapTime() {
        RacingRecord lapTimes = new RacingRecord();
        for (Car car : cars) {
            lapTimes.add(car.getSkidMark());
        }
        return lapTimes;
    }

    public List<Car> getWinners(List<Car> cars) {
        int winnerPosition = getWinnerPosition(cars);
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            findWinner(winnerPosition, winners, car);
        }

        return winners;
    }

    private void findWinner(int winnerPosition, List<Car> winners, Car car) {
        if (car.isWinner(winnerPosition)) {
            winners.add(car);
        }
    }

    public List<Car> getWinners() {
        return getWinners(this.cars);
    }
}
