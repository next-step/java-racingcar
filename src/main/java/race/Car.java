package race;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car {

    private String name;

    private List<Boolean> distance = new ArrayList<>();

    public List<Boolean> getDistance() {
        return Collections.unmodifiableList(distance);
    }

    public String getName() {
        return name;
    }

    public void addDistance(MoveCondition moveCondition) {
        distance.add(moveCondition.moveOrNot());
    }

    public Car(String name, List<Boolean> distance) {
        this.name = name;
        this.distance = distance;
    }

    public Car() {
    }
}
