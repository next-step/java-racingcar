package study.racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<Car> winners;
    private final int maxPosition;

    public Winners(List<Car> cars) {
        this.maxPosition = findMaxPosition(cars);
        this.winners = findWinners(cars, maxPosition);
    }

    private int findMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    private List<Car> findWinners(List<Car> cars, int maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        for (Car car : winners) {
            names.add(car.getName());
        }
        return names;
    }

    public int getMaxPosition() {
        return maxPosition;
    }
}
