package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Winners {
    private final List<Car> winners;

    private Winners(List<Car> winners) {
        this.winners = winners;
    }

    public static Winners from(List<Car> winners) {
        return new Winners(winners);
    }

    public List<Car> getWinners() {
        return Collections.unmodifiableList(winners);
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
