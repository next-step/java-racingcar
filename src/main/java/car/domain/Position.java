package car.domain;

public class Position {

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void increasePosition() {
        this.position++;
    }

    public boolean isGreaterThan(int maxPosition) {
        return this.position > maxPosition;
    }

    public boolean isEqualPosition(int maxPosition) {
        return this.position == maxPosition;
    }

    public int getPosition() {
        return this.position;
    }
}
