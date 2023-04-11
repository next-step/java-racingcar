package study.step3;

import java.util.Random;

public class Car {
    private int move = 0;
    private static final Random random = new Random();
    private static final int STARTING_CONDITION = 4;
    private static final int RANDOM_RANGE = 10;
    private int attemptCount = 0;
    private int finish;

    Car(int finish) {
        this.finish = finish;
    }

    public void move() {
        moveCar(isMove(random.nextInt(RANDOM_RANGE)));
        attemptCount++;
    }

    public Boolean isMove(int input) {
        return input >= STARTING_CONDITION;
    }

    public void moveCar(boolean moveResult) {
        if (moveResult) {
            move++;
        }
    }

    public Boolean isFinish() {
        return finish == attemptCount;
    }

    public int getMove() {
        return move;
    }

    public int getAttemptCount() {
        return attemptCount;
    }

}
