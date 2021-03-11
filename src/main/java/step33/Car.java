package step33;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {
    public static final int POSSIBLE_MOVE_NUMBER = 3;

    private int moveCount;

    public int moveCars(int number) {
        if (number > POSSIBLE_MOVE_NUMBER) {
            moveCount++;
        }
        return moveCount;
    }
}
