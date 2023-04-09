package racing;

public class Car {

    private int position = 1;
    public void move() {
        position++;
    }

    public int valueOfCurrentPosition() {
        return position;
    }
}
