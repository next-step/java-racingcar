package step3.stretegy;

import java.util.Random;
import java.util.function.Supplier;

public class Dice implements MoveStrategy<Integer>{

    private static final Integer DICE_BOUND = 10;

    private static final Integer MOVE_ABLE_SCORE = 4;

    private final Random dice = new Random();

    @Override
    public Supplier<Integer> attemptMove() {
        return () -> this.dice.nextInt(DICE_BOUND);
    }

    @Override
    public boolean isAbleToMove(Supplier<Integer> supplier) {
        return supplier.get() >= MOVE_ABLE_SCORE;
    }
}
