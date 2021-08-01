package racingcar.step5.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Winner {
    private List<Car> cars;

    public Winner(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        Collections.sort(cars);
        findWinners(winners);
        return winners;
    }

    private void findWinners(List<String> winners) {
        for (Car car : cars) {
            addWinner(car, winners);
        }
    }

    private List<String> addWinner(Car car, List<String> winners) {
        int maxDistance = cars.get(0).getDistance();
        if (car.getDistance() == maxDistance) {
            winners.add(car.getName());
        }
        return winners;
    }
}

