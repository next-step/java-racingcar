package racingcar;

public class Car {
    private int position;

    public int move() {
        position++;
        return position;
    }

    public int stay() {
        return position;
    }
}
