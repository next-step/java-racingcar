package domain;

import static core.Random.generateRandom;

import java.util.stream.IntStream;

public class Move {

    public static final int MINIMUM_MOVABLE_VALUE = 4;
    public static final int OUT_OF_TEN = 10;
    private int move;


    public int getMove() {
        return move;
    }

    static boolean isMoved() {
        int movingToken = generateRandom(OUT_OF_TEN);
        return movingToken > MINIMUM_MOVABLE_VALUE;
    }

    void attemptMove(int attemptCount) {
        IntStream.range(0, attemptCount)
                .filter(attempt -> isMoved())
                .forEach(success -> move++);
    }

}
