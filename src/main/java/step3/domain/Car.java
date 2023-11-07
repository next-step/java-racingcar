package step3.domain;

public class Car {

    private static final int DEFAULT_POSITION = 0;
    private static final int MOVE_BOUND = 4;

    private Name name;
    private Position position;

    public Car(String name) {
        this(name, DEFAULT_POSITION);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void move(int random) {
        if (canMove(random)) {
            this.position.forward();
        }
    }

    private boolean canMove(int random) {
        return random >= MOVE_BOUND;
    }

    public Name name() {
        return this.name;
    }

    public Position position() {
        return this.position;
    }

    public boolean isMaxPosition(int maxPosition) {
        return this.position.isSamePosition(maxPosition);
    }

}
