package racingGame.domain;

import racingGame.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    private final List<Car> winners;
    public Integer position;

    public Winner(List<Car> winners) {
        this.winners = winners;
        this.position = maxPosition();
    }

    public List<String> findWinnerNames() {
        return winners.stream().filter(w -> w.getPosition() == position)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int maxPosition() {
        return winners.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }
}
