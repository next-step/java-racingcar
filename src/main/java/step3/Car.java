package step3;

import java.util.stream.IntStream;

public class Car {
    public static final String NOT_MOVED = " ";
    public static final String WAY = "-";

    private int moveCount;

    public void move() {
        this.moveCount++;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public String getWayResult() {
        if (isNotMoved()) {
            return NOT_MOVED;
        }
        return IntStream.range(0, moveCount)
                .mapToObj(i -> WAY)
                .reduce("", (prev, element) -> prev + element);
    }

    private boolean isNotMoved() {
        return moveCount == 0;
    }
}
