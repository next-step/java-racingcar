package racing.domain;

import java.util.Comparator;

public class Car implements Comparator<Car> {
    private final MovingRule movingRule;
    private int location;

    public Car(MovingRule movingRule) {
        this.movingRule = movingRule;
    }

    public void move() {
        if (movingRule.isPossibleToMove()) {
            location++;
        }
    }

    @Override
    public int compare(Car o1, Car o2) {
        return Integer.compare(o1.location, o2.location);
    }

    public int location() {
        return location;
    }
}
