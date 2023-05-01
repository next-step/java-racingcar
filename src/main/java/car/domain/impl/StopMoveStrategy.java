package car.domain.impl;

import car.domain.Movable;

import java.util.Random;

public class StopMoveStrategy implements Movable {
    Random random = new Random();
    @Override
    public int moveStrategy() {
        return random.nextInt(4);
    }
}
