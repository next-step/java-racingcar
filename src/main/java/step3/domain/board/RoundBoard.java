package step3.domain.board;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;
import static step3.utils.ValidationUtils.checkState;

public class RoundBoard {

    private final List<Integer> records = new ArrayList<>();

    public void record(Integer location) {
        checkState(location != null, "location is required.");
        records.add(location);
    }

    public List<Integer> getRecords() {
        return unmodifiableList(records);
    }
}
