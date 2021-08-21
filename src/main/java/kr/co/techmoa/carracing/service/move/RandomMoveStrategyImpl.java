package kr.co.techmoa.carracing.service.move;

import java.util.Random;

public class RandomMoveStrategyImpl implements MoveStategy{
    public static final int OPERATION_MAX = 10;
    public static final Random RANDOM = new Random();

    @Override
    public int move() {
        return RANDOM.nextInt(OPERATION_MAX);
    }
}
