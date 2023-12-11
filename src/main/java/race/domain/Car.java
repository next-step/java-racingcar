package race.domain;

public class Car {

    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            this.position.moveForward();
        }
    }
    public boolean isSamePosition(int position) {
        return this.position.isSame(position);
    }
    public int position() {
        return position.position();
    }

    public String name() {
        return name.name();
    }


}
