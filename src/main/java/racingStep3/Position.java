package racingStep3;

public class Position {

    private int location;

    public Position() {
        this(0);
    }

    public Position(int location) {
        this.location = location;
    }

    public int value() {
        return this.location;
    }
}
