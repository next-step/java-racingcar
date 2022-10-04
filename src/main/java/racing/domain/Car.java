package racing.domain;

import java.util.Comparator;

public class Car implements Comparator<Car> {
    private final MovingRule movingRule;
    private final String name;
    private int location;


    public Car(MovingRule movingRule, String name) {
        this.movingRule = movingRule;
        this.name = name;
    }

    public void move() {
        if (movingRule.isPossibleToMove()) {
            location++;
        }
    }

    public String name(){
        return name;
    }

    @Override
    public int compare(Car o1, Car o2) {
        return Integer.compare(o1.location, o2.location);
    }

    public int location() {
        return location;
    }
}
