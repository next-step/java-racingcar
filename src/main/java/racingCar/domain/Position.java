package racingCar.domain;

public class Position {

    private int position = 0;

    public Position() {
    }

    public int forward() {
        position += 1;
        return position;
    }

    public int getPosition() {
        return position;
    }
}
