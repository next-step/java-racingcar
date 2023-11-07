package ch3;

public class Car {

    private int position = 0;

    public int getPosition() {
        return position;
    }

    public void move(int number) {
        final int MOVE_CONDITION_NUMBER = 4;
        if (number >= MOVE_CONDITION_NUMBER) {
            this.position++;
        }
    }
}
