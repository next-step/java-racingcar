package racingcar.domain.car;

public class Position {

    private static final int DEFAULT_POSITION = 0;
    private int location;

    public Position() {
        this.location = DEFAULT_POSITION;
    }


    public int getPosition() {
        return this.location;
    }

    public void move(final int number) {
        this.location += number;
    }
}
