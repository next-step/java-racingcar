package racingcar;

import exception.OutOfRangeException;

public class Car {
    private int moveCount;

    public void move(int random) {
        if (random < 0 || random > 9) {
            throw new OutOfRangeException(random);
        }
        if (random >= 4) moveCount++;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
