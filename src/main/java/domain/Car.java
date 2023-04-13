package domain;

public class Car {
    private static final int RANDOM_CONDITION = 4;
    private int distance = 0;

    public void move(int random) {
        if (isCanMove(random)) {
            distance += 1;
        }
    }

    private boolean isCanMove(int random) {
        return random >= RANDOM_CONDITION;
    }

    public int getDistance() {
        return distance;
    }
}
