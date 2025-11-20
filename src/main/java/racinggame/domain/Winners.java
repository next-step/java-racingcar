package racinggame.domain;

import java.util.List;

public class Winners {
    private final List<Car> winners;

    public Winners(List<Car> winners) {
        validate(winners);
        this.winners = winners;
    }

    private static void validate(List<Car> winners) {
        if (winners == null || winners.isEmpty()) {
            throw new IllegalArgumentException("우승자는 최소 한명 이상이어야 합니다.");
        }
    }

    public List<String> getWinnerNames() {
        return winners.stream().map(Car::getName).toList();
    }

    public String getCommaSeparatedWinnerNames() {
        return String.join(", ", getWinnerNames());
    }

    public int size() {
        return winners.size();
    }

    public boolean contains(Car car) {
        return winners.contains(car);
    }
}
