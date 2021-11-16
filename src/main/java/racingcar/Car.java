package racingcar;

import racingcar.util.NumberGenerator;

public class Car {

    private final String name;
    private int location;

    public Car(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public void move(NumberGenerator numberGenerator) {
        final int moveNumber = numberGenerator.generate();
        this.location = this.location + moveNumber;
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
