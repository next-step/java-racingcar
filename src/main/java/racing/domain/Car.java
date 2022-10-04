package racing.domain;

import java.util.Comparator;

public class Car implements Comparator<Car> {
    private final static int MAX_LENGTH_OF_NAME = 5;

    private final MovingRule movingRule;
    private final String name;
    private int location;


    public Car(MovingRule movingRule, String name) {
        this.movingRule = movingRule;
        this.name = name;
        validateName();
    }

    private void validateName() {
        if (name.length() > MAX_LENGTH_OF_NAME) {
            throw new IllegalArgumentException("자동차의 이름은 5자를 초과할수 없습니다.");
        }
    }

    public void move() {
        if (movingRule.isPossibleToMove()) {
            location++;
        }
    }

    public String name() {
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
