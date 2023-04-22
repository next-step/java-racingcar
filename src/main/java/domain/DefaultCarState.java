package domain;

public class DefaultCarState implements CarState {
    private final int position;

    private DefaultCarState(int position) {
        this.position = position;
    }

    public static DefaultCarState create(int position) {
        return new DefaultCarState(position);
    }

    @Override
    public int position() {
        return position;
    }
}
