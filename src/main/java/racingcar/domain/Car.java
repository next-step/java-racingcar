package racingcar.domain;

public class Car {
    private int position = 1;

    public void advance(final boolean advance) {
        if (advance) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
