package racing.model;

public class Position {
    private static final int ONE_SPACE = 1;

    private int position;

    void increaseOne() {
        position += ONE_SPACE;
    }

    int getPosition() {
        return position;
    }
}
