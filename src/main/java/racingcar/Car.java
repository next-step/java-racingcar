package racingcar;

import exception.OutOfRangeException;

public class Car {

    public int moveCount;

    public void move(int random) {
        if (random < 0 || random > 9) {
            throw new OutOfRangeException(random);
        }
        if (random >= 4) moveCount++;
    }
}
