package car.domain.impl;

import car.domain.Movable;

import java.util.Random;

public class GoMoveStrategy implements Movable {
    Random random = new Random();
    @Override
    public int moveStrategy() {
        return random.nextInt(6)+4;
    }
}
