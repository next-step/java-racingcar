package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class RacingGameResult {
    private List<String> winners = new ArrayList<>();

    public List<String> getWinners() {
        return winners;
    }

    public List<String> collectWinners(List<Car> cars) {
        Car firstWinner = cars.stream()
            .max(Comparator.comparing(Car::getPosition))
            .orElseThrow(NoSuchElementException::new);
        for(Car car : cars) {
            comparePosition(firstWinner, car);
        }
        return winners;
    }

    void comparePosition(Car firstWinner, Car otherPlayer) {
        if (firstWinner.getPosition() == (otherPlayer.getPosition())) {
            winners.add(otherPlayer.getName());
        }
    }
}