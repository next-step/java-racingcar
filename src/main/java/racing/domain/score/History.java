package racing.domain.score;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import racing.domain.car.Cars;

public final class History {

    private final List<Cars> history;

    public History(List<Cars> history) {
        this.history = Collections.unmodifiableList(history);
    }

    public History save(Cars cars) {
        List<Cars> carsList = new ArrayList<>(history);
        carsList.add(cars);
        return new History(carsList);
    }

    public List<Cars> history() {
        return new ArrayList<>(history);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        History history1 = (History) o;
        return Objects.equals(history, history1.history);
    }

    @Override
    public int hashCode() {
        return Objects.hash(history);
    }
}
