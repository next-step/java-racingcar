package racingcar.service;

import java.util.Random;

public class MoveRandom implements Move {
    private final int STANDARD = 4;
    private final boolean GO = true;
    private final boolean STOP = false;

    @Override
    public boolean goOrStop(int num) {
        if (num > STANDARD) {
            return GO;
        }
        return STOP;
    }
}
