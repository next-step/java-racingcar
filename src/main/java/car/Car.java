package car;

public class Car {

    private int position;

    public void moveOrStopByRandomValue(int i) {
        if (i >= 4) {
            position += 1;
        }
    }

    public int getPosition() {
        return position;
    }
}
