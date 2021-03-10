package step33;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {

    private int moveCount;

    public int moveCars(boolean isOver) {
        if (isOver) {
            moveCount++;
        }
        return moveCount;
    }
}
