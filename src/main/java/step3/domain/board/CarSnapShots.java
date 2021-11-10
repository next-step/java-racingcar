package step3.domain.board;

import java.util.List;
import java.util.Objects;

import static java.util.Collections.unmodifiableList;

public class CarSnapShots {

    private final List<CarSnapshot> carSnapshots;

    public CarSnapShots(List<CarSnapshot> carSnapshots) {
        this.carSnapshots = carSnapshots;
    }

    public List<CarSnapshot> getCarSnapshots() {
        return unmodifiableList(carSnapshots);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarSnapShots that = (CarSnapShots) o;
        return Objects.equals(carSnapshots, that.carSnapshots);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carSnapshots);
    }
}
