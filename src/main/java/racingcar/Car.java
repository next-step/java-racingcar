package racingcar;

import java.util.Random;

public class Car {
    private final boolean[] moves;
    private final static int MOVE_POINT = 4;
    private final static int RANDOM_NUMBER_BOUND = 10;

    public Car(int attempts) {
        this.moves = new boolean[attempts];
    }

    public boolean[] getMoves() {
        return moves;
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }

    public void generateMoves() {
        for (int i = 0; i <moves.length ; i++) {
            moves[i] = getRandomNumber() >= MOVE_POINT;
        }
    }
}
