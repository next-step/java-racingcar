package race;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car {

    private List<Boolean> distance = new ArrayList<>();

    protected List<Boolean> getDistance() {
        return Collections.unmodifiableList(distance);
    }

    public void addDistance(MoveCondition moveCondition) {
        distance.add(moveCondition.moveOrNot());
    }

}
