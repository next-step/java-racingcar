package racinggame.domain;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winners winners1 = (Winners) o;
        return Objects.equals(winners, winners1.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winners);
    }
}
