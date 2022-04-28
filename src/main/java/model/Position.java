package model;

public class Position implements Comparable<Position> {

    private static final int MINIMUM_POSITION = 0;
    private static final String EXCEED_MINIMUM_POSITION_ERROR_MESSAGE = "위치는 0이상 이여야 됩니다.";

    private int position;

    public Position(int position) {
        if (position < MINIMUM_POSITION) {
            throw new IllegalStateException(EXCEED_MINIMUM_POSITION_ERROR_MESSAGE);
        }
        this.position = position;
    }

    public void plus() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Position obj) {
        return Integer.compare(this.position, obj.getPosition());
    }
}
