package step4racinggamewinner;

public class Position {
    private int position = 0;

    public Position(int positionNumber) {
        position = positionNumber;
    }

    public void updateMovement(int movement) {
        position += movement;
    }

    public int currentPosition() {
        return position;
    }
}
