package domain;

import static core.RandomMoveFactory.isMoved;

public class Move {


    private String distance = "";
    private final static String DISTANCE_BLOCK = "-";

    public String getCarCurrentDistance() {
        return distance;
    }

    static boolean movingCheck() {
        return isMoved();
    }

    void attemptMove() {
        if (movingCheck()) {
            distance += DISTANCE_BLOCK;
        }
    }
}
