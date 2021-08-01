package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<String> names = new ArrayList<>();
    private Distance distance = new Distance();

    public List<String> getNames() {
        return names;
    }

    public Distance getDistance() {
        return distance;
    }

    public void updateWinner(Record record) {
        if (distance.getDistance() < record.getDistance()) {
            names.clear();
            names.add(record.getName());
            distance = new Distance(record.getDistance());
            return;
        }
        if (distance.getDistance() == record.getDistance()) {
            names.add(record.getName());
        }
    }
}
