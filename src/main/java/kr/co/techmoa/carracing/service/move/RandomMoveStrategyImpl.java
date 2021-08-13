package kr.co.techmoa.carracing.service.move;

import java.util.Random;

public class RandomMoveStrategyImpl implements MoveStategy{
    public static final int OPERATION_MAX = 10;

    @Override
    public int move() {
        return new Random().nextInt(OPERATION_MAX);
    }
}
