package domain;

public class CarPosition {
    private int position;

    public CarPosition(int position) {
        this.position = position;
    }

    public void positionPlus(int plusNumber) {
        position += plusNumber;
    }

    public int value() {
        return position;
    }
}
