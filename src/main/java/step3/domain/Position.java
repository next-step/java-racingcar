package step3.domain;

public class Position {

    private static class PositionInstanceHolder {
        private static final Position INSTANCE = new Position();
    }

    private int position;

    public void increase() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public static Position getInstance() {
        return PositionInstanceHolder.INSTANCE;
    }
}
