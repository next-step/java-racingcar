package racingcar;

public class Position {
    private int position;

    public Position() {
        this.position = 0;
    }

    public void moveForward() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }
}
