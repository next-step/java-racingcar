package study.racingcar.domain;

public class Position {
    private int position;

    public Position() {
        this.position = 0;
    }

    public Position(int position) {
        this.position = position;
    }

    public void increase() {
        this.position++;
    }

    public boolean isEqualTo(int num) {
        return num == position;
    }

    @Override
    public String toString() {
        return String.valueOf(position);
    }
}
