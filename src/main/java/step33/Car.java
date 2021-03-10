package step33;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {

    private int moveCount;

    public String moveCars(boolean isOver) {
        if (isOver) {
            moveCount++;
        }
        return getMove();
    }

    private String getMove() {
        return IntStream.range(0, moveCount)
                .mapToObj(moveCount -> "-")
                .collect(Collectors.joining());
    }
}
