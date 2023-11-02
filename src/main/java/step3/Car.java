package step3;

import java.util.Random;

public class Car {

    private static final int RANDOM_BOUND = 10;
    private static final int MOVE_BOUND = 4;
    private static final Random random = new Random();

    private int position;

    public int random() {
        return random.nextInt(RANDOM_BOUND);
    }

    public void move() {
        int random = random();

        if (canMove(random)) {
            position++;
        }
    }

    private boolean canMove(int random) {
        return random >= MOVE_BOUND;
    }

    public int position() {
        return this.position;
    }

}
