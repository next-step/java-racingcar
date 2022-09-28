package racing.game;

import racing.game.random.RandomNumber;

public class Car {

    private static final int BOUND = 10;
    private static final int MOVABLE_LIMIT = 4;

    private final RandomNumber random;
    private final String name;
    private int position;

    public Car(String name, RandomNumber random) {
        this.name = name;
        this.position = 0;
        this.random = random;
    }

    public void move() {
        if (isMovable() || isOnStartLine()) {
            moveForward();
        }
    }

    public String name() {
        return name;
    }

    public int currentPosition() {
        return position;
    }


    private boolean isMovable() {
        return random.generate(BOUND) >= MOVABLE_LIMIT;
    }

    private boolean isOnStartLine() {
        return position == 0;
    }

    private void moveForward() {
        position++;
    }
}
