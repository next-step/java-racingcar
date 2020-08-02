package step3.stretegy;

import java.util.function.Supplier;

public interface MoveStrategy<T> {

    Supplier<T> attemptMove();

    boolean isAbleToMove(Supplier<T> supplier);
}
