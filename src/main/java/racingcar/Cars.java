package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void race() {
        for (Car current : cars) {
            current.move(RandomGenerator.generate());
            ResultView.printCarDistanceWithName(current.getDistance(), current.getCarName());
        }
    }

    public String findWinnersString() {
        List<Car> winners = findWinners();
        String[] winnersStr = new String[winners.size()];
        for (Car winner : winners) {
            winnersStr[winners.indexOf(winner)] = winner.getCarName();
        }
        return String.join(", ", winnersStr);
    }

    public List<Car> findWinners() {
        List<Car> winners = new ArrayList<>();
        int maxDistance = getMaxDistance();
        for (Car current : cars) {
            addWinners(winners, maxDistance, current);
        }
        return winners;
    }

    private int getMaxDistance() {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }
        return maxDistance;
    }

    private void addWinners(List<Car> winners, int maxDistance, Car car) {
        if (car.isWinner(maxDistance)) {
            winners.add(car);
        }
    }
}
