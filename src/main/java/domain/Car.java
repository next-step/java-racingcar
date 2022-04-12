package domain;

public class Car {
    private static final int BOUNDARY_NUMBER = 4;
    private int position;

    public void move(int number) {
        if (number >= BOUNDARY_NUMBER) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
