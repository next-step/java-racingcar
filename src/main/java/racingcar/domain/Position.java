package racingcar.domain;

public class Position {

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void increase() {
        this.position++;
    }

    public int max(int other) {
        if (this.position > other) {
            return this.position;
        }

        return other;
    }

    public boolean isMatch(int maxPosition) {
        return this.position == maxPosition;
    }
}
