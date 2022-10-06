package racingcar.domain;

import java.util.List;
import java.util.Objects;

public class Winners {

    private final List<Car> elements;

    public Winners(final List<Car> elements) {
        this.elements = elements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winners winners = (Winners) o;
        return Objects.equals(elements, winners.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }

    public List<Car> getElements() {
        return List.copyOf(elements);
    }
}
