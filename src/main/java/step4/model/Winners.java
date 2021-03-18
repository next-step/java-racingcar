package step4.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Winners {
    private final List<Car> winners;

    public Winners() {
        this(new ArrayList<>());
    }

    public Winners(List<Car> cars) {
        this.winners = cars;
    }

    public void addWinner(Car winner) {
        this.winners.add(winner);
    }

    public String winnerNames() {
        List<String> winnerNames = new ArrayList<>();
        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }
        return String.join(",", winnerNames);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Winners otherWinners = (Winners) other;
        return Objects.equals(winners, otherWinners.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winners);
    }
}
