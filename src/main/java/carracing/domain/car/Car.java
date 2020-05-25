package carracing.domain;

import carracing.RandomValue;

public class Car {

    private String name;
    private String number;
    private Position position;
    private final int  MOVE_CHECK_VALUE = 4;

    public Car(String number, Position position) {
        this.number = number;
        this.position = position;
    }

    public Car(String name, String number, Position position) {
        this.name = name;
        this.number = number;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void move(Direction direction) {
        direction.exec(this.position);
    }

    public int getLocation() {
        return position.getLocation();
    }

    public void progress(RandomValue randomValue) {
        if (this.moveCheck(randomValue)) {
            this.move(Direction.FORWARD);
        }
    }

    public boolean isLocationAt(int location) {
        return this.getLocation() == location;
    }

    private boolean moveCheck(RandomValue randomValue) {
        return randomValue.getRandomValue() >= MOVE_CHECK_VALUE;
    }
}
