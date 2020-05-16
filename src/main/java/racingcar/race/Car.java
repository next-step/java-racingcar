package racingcar.race;

public class Car {
    private int position = 0;

    public void drive(int count) {
        position += count;
    }

    public int getPosition() {
        return position;
    }
}
