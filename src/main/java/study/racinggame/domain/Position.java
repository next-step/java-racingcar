package study.racinggame.domain;

public class Position {
    private int position;

    public Position() {
    }

    public Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public boolean isHigherPosition(int another) {
        return position > another;
    }

    public boolean isMaxPosition(int maxPosition) {
        return position == maxPosition;
    }

    public void increase() {
        position++;
    }
}
