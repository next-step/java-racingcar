package car.Impl;

import car.Move;

import java.util.Random;

public class MoveRandem implements Move {

   private static final Random random = new Random();


    @Override
    public int MoveRandem() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
