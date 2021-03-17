package step3.study.domain;

public class Position {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void increase() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }
}
