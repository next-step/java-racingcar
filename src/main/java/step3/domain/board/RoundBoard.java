package step3.domain.board;

import step3.domain.car.Location;
import step3.domain.car.Name;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.unmodifiableList;

public class RoundBoard {

    private final List<CarSnapshot> records = new ArrayList<>();

    public void record(Location location, Name name) {
        records.add(new CarSnapshot(location, name));
    }

    public List<CarSnapshot> getRecords() {
        return unmodifiableList(records);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoundBoard that = (RoundBoard) o;
        return Objects.equals(records, that.records);
    }

    @Override
    public int hashCode() {
        return Objects.hash(records);
    }
}
