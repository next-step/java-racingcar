package racing.controller;

import racing.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingWinner {

    public List<Car> getWinnerList(List<Car> cars) {
        List<Car> winners = new ArrayList<>();
        int maxDistance = getMaxDistance(cars);
        for (Car car : cars) {
            addWinner(maxDistance, winners, car);
        }
        return winners;
    }

    private int getMaxDistance(List<Car> cars) {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = Math.max(car.getDistance(), maxDistance);
        }
        return maxDistance;
    }

    private void addWinner(int maxDistance, List<Car> winners, Car car) {
        if(isWinner(maxDistance, car)) {
            winners.add(car);
        }
    }

    private boolean isWinner(int maxDistance, Car car) {
        return car.getDistance() == maxDistance;
    }
}
