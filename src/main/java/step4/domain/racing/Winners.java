package step4.domain.racing;

import step4.domain.car.Car;

import java.util.List;
import java.util.Objects;

public final class Winners {

    private final List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = winners;
    }

    public final List<Car> winners() {
        return winners;
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
