package racingcar.domain;

public class Car {

    private final String name;
    private int position = 0;

    public Car(final String name) {
        this.name = name;
    }

    public void updatePosition() {
        this.position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return this.position;
    }

}
