package study.step4.domain;

public class Position {

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void forward() {
        position += 1;
    }

    public boolean eq(int value) {
        return position == value;
    }

    public boolean gt(int value) {
        return position >= value;
    }

}
