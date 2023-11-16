package carracing.domain.car;

import java.util.Objects;

public class Winners {
    private final Cars winners;

    public Winners(Cars winners) {
        this.winners = winners;
    }

    public void printWinners() {
        winners.printWinners();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winners winnerList = (Winners) o;
        return Objects.equals(winners, winnerList.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winners);
    }
}
