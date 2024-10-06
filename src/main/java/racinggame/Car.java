package racinggame;

public class Car {

    private int position = 0;

    public void move(int number) {
        if (4 <= number) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
