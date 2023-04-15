package car;

public class Car {

    private static final int DEFAULT_POSITION = 0;

    private final Name name;
    private int position;

    public Car(String name) {
        this.position = DEFAULT_POSITION;
        this.name = new Name(name);
    }

    public int getPosition() {
        return this.position;
    }

    public void move(MoveStrategy moveStrategy) {
        if(moveStrategy.movable()) {
            position++;
        }
    }
}
