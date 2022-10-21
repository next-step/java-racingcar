package racing.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    private final List<Car> winner;

    public Winner(List<Car> carList) {
        this.winner = findWinners(carList);
    }

    private List<Car> findWinners(List<Car> carList) {
        return findWinners(carList, findMaxPosition(carList));
    }

    private List<Car> findWinners(List<Car> carList, Position maxPosition) {
        return carList.stream()
                .filter(p -> p.getPosition().equals(maxPosition))
                .collect(Collectors.toList());
    }

    public String findWinnersName() {
        return winner.stream()
                .map(c -> c.getName())
                .collect(Collectors.joining(", "));
    }

    private Position findMaxPosition(List<Car> carList) {
        return Collections.max(carList).getPosition();
    }

    public List<Car> getWinners() {
        return winner;
    }

    public Position getMaxPosition() {
        return winner.get(0).getPosition();
    }
}
