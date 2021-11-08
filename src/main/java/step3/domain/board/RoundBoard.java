package step3.domain.board;

import step3.domain.car.Location;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;
import static step3.utils.ValidationUtils.checkArgument;

public class RoundBoard {

    private final List<Location> records = new ArrayList<>();

    public void record(Location location) {
        checkArgument(location != null, "location is required.");
        records.add(location);
    }

    public List<Location> getRecords() {
        return unmodifiableList(records);
    }
}
