package car.Impl;

import car.Move;

import java.util.Random;

public class MoveOver implements Move {
    @Override
    public int MoveRandem() {
        Random random = new Random();
        return random.nextInt(6)+4;
    }
}
