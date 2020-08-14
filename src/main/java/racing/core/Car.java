package racing.core;

public class Car {

    private int position;

    public Snapshot move(Move movement) {
        return new Snapshot(movement.canMove() ? ++position : position);
    }
}
