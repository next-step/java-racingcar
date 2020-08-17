package racing.core;

public class Car {

    private int position;

    public Snapshot move(MoveStrategy movement) {
        if (movement.canMove()) {
            position++;
        }
        return new Snapshot(position);
    }
}
