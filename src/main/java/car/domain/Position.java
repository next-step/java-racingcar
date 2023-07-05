package car.domain;

public class Position {
    private int position;
    Position(int num) {
        validatePosition(num);
        this.position = num;
    }
    private void validatePosition (int num) {
        if (num < 0) throw new RuntimeException();
    }
    public int getPosition() {
        return position;
    }
    public void increasePosition() {
        position++;
    }
}
