package carrace;

import carrace.moving.RandomMoving;

public class Car {

    private final RandomMoving randomMoving = new RandomMoving();

    private final String name;

    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void race() {
        this.position += move(randomMoving);
    }

    private int move(RandomMoving randomMoving) {
        return randomMoving.move(randomMoving.isMove());
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
