package racing.car;

public class Position {

    private int value;

    public Position(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Position increase() {
        this.value++;
        return this;
    }

    public int maxPosition(int maxPosition) {
        if (this.value < maxPosition) {
            return maxPosition;
        }
        return this.value;
    }

    public boolean isSame(int maxPosition) {
        return this.value == maxPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return value == position.value;
    }

}
