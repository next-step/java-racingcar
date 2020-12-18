package racingcar.domain;

public class Car {
    private Position position = new Position();
    private final Name name;

    public Car(Name name) {
        this.name = name;
    }

    public void play(RandomNumber randomNumber) {
        if (randomNumber.movable()) {
            move();
        }
    }

    private void move() {
        this.position.add();
    }

    public int position() {
        return this.position.getPosition();
    }

    public boolean isMoved() {
        return this.position.isMoved();
    }

    public String name() {
        return this.name.getName();
    }

    public boolean isEqualsPosition(int position) {
        return this.position() == position;
    }
}
