package car.Impl;

import car.Move;

import java.util.Random;

public class MoveUnder implements Move {


    @Override
    public int MoveRandem() {
        Random random = new Random();
        return random.nextInt(4);
    }
}
