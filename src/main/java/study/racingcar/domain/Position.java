package study.racingcar.domain;

public class Position {
    private int position;

    public Position() {
        this.position = 0;
    }

    public void increase() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }
}
