package ch3;

public class Car {

    private int position = 0;

    public int getPosition() {
        return position;
    }

    public void move(int number) {
        if (number >= 4) {
            this.position++;
        }
    }
}
