package car_racing2.domain.model;

public class Position {
    private static final String POSITION_MARKER = "-";
    private int position = 0;

    public void changePosition(int difference) {
        this.position += difference;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return POSITION_MARKER.repeat(this.position);
    }
}
