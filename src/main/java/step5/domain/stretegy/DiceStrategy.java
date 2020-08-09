package step5.domain.stretegy;

import java.util.function.IntSupplier;

public class DiceStrategy implements MoveStrategy {

    private static final int DICE_BOUND = 10;

    private static final int MOVE_ABLE_SCORE = 4;

    private final IntSupplier diceSupplier;

    public DiceStrategy() {
        this.diceSupplier = () -> new BoundedDice(DICE_BOUND).rollDice();
    }
    //For Test Code
    public DiceStrategy(IntSupplier diceSupplier) {
        this.diceSupplier = diceSupplier;
    }

    @Override
    public boolean isAbleToMove() {
        return rollDice() >= MOVE_ABLE_SCORE;
    }

    private int rollDice() {
        return diceSupplier.getAsInt();
    }
}
