package step03Refactor;

public class Position {
    private int position = 0;

    public Position() {
    }

    public Position(int position) {
        this.position = position;
    }

    public boolean isBiggerPosition(int compareValue) {
        return position >= compareValue;
    }

    public boolean isSamePosition(int compareValue) {
        return position == compareValue;
    }

    public int getPosition() {
        return position;
    }

    public int increase() {
        return ++position;
    }

}
