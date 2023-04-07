package domain;

import java.util.Random;
import java.util.stream.IntStream;

public class Move {

    private int move;

    public int getMove() {
        return move;
    }

    static boolean isMoved() {
        Random random = new Random();
        int movingToken = random.nextInt(10);
        return movingToken > 4;
    }

    void attemptMove(int attemptCount) {
        IntStream.range(0, attemptCount)
                .filter(attempt -> isMoved())
                .forEach(success -> move++);
    }

}
