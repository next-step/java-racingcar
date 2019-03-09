package racingcar;

public class Car {
    private int position = 0;

    int getPosition() {
        return position;
    }

    int addPosition() {
        return this.position += 1;
    }
}
