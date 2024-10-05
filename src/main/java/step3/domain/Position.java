package step3.domain;

public class Position {
    private int position;

    public static Position zeroPosition() {
        return new Position();
    }

    public void forwardOnce() {
        position += 1;
    }

    public int getPosition() {
        return position;
    }

}
