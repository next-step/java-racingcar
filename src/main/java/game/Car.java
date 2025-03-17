package game;

public class Car {
    private static final int MOVE_CONDITION = 4;

    private final PositiveInteger position;
    private final CarName name;

    public Car(CarName name) {
        this.position = new PositiveInteger(0);
        this.name = name;
    }

    public void move(int number) {
        if (number >= MOVE_CONDITION) {
            position.addOne();
        }
    }

    public int position() {
        return position.value();
    }
}
