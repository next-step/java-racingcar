package step4racinggamewinner;

public class Position {
    private int position;

    public Position(int positionNumber) {
        position = positionNumber;
    }

    public void updatePosition(int movement) {
        position += movement;
    }

    public int currentPosition() {
        return position;
    }
}
