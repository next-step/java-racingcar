package racing;

public class Car {

    private int position = 0;
    public void move() {
        position++;
    }

    public int valueOfCurrentPosition() {
        return position;
    }
}
