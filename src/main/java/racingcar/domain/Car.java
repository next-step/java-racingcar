package racingcar.domain;

public class Car {

    private final String name;
    private int location;

    public Car(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public void move(MoveStrategy moveStrategy) {
        this.location = this.location + moveStrategy.moveValue();
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
