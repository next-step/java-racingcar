package game;

public class Car {
    private final int id;
    private int position;
    private final MovePolicy movePolicy;

    public Car(int id, int position, MovePolicy movePolicy) {
        this.id = id;
        this.position = position;
        this.movePolicy = movePolicy;
    }

    public void move() {
        position = movePolicy.getPosition(position);
    }

    public int getPosition() {
        return position;
    }
}
