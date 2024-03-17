package step3.application.domain.model;

import java.util.List;
import java.util.Objects;

public class OneMoveRecord {
    private final List<MovementLog> carLocation;

    public OneMoveRecord(List<MovementLog> carLocation) {
        this.carLocation = carLocation;
    }

    public List<MovementLog> getCarLocation() {
        return carLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OneMoveRecord)) return false;
        OneMoveRecord that = (OneMoveRecord) o;
        return Objects.equals(carLocation, that.carLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carLocation);
    }
}
