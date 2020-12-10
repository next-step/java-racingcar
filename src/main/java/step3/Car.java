package step3;

import java.util.stream.IntStream;

public class Car {

    public static final String NOT_MOVED = " ";
    public static final String WAY = "-";

    private String name;
    private int moveCount;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        this.moveCount++;
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    public String getName() {
        return name;
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

    public boolean isWinner(int winnerMoveCount) {
        return this.moveCount == winnerMoveCount;
    }

}
