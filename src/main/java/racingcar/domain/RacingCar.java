package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCar {
    private final static int NUMBER_OF_MOVES = 4;

    private int position;

    public RacingCar() {
        position = 0;
    }

    public void move(int randomInt) {
        if (randomInt >= NUMBER_OF_MOVES)
            position++;
    }

    public int getPosition() {
        return position;
    }
}
