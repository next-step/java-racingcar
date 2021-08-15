package racingcar.domain;

public class Car {
    private static int ID_INDEX = 1;
    private int id;
    private Name name;
    private Position position;

    public Car(String name) {
        this.id = ID_INDEX++;
        this.name = new Name(name);
        this.position = new Position();
    }

    public void move(MovableStrategy movable) {
        if (movable.canMove()) {
            position = new Position(position.getPosition() + 1);
        }
    }

    public int getId() {
        return id;
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }
}
