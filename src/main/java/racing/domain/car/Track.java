package racing.domain.car;

import java.util.List;
import java.util.Objects;
import racing.domain.score.History;

public final class Track {

    private final Cars cars; // 실제 경주하는 애
    private final History history; // 전광판

    public Track(History history, Cars cars) {
        this.history = history;
        this.cars = cars;
    }

    public Track racing(Labs labs) {
        return labs.racing(history, cars);
    }

    public History getHistory() {
        return history;
    }

    public List<Name> winner() {
        return cars.farPeople();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Track track = (Track) o;
        return Objects.equals(cars, track.cars) && Objects.equals(history, track.history);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, history);
    }
}
