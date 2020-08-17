package racing.core;

public class Car {

    private int position;

    public TrackInfo move(MoveStrategy movement) {
        if (movement.canMove()) {
            position++;
        }
        return new TrackInfo(position);
    }
}
