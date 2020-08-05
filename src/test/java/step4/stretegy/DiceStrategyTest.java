package step4.stretegy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.stretegy.DiceStrategy;
import step4.stretegy.MoveStrategy;

import java.util.function.IntSupplier;

import static org.assertj.core.api.Assertions.assertThat;

class DiceStrategyTest {

    private static final IntSupplier UNDER_FOUR_SUPPLIER = () -> 3;
    private static final IntSupplier EQUAL_OR_OVER_FOUR_SUPPLIER = () -> 4;

    @DisplayName("4 미만의 supplier 값이 들어오면 false 리턴한다.")
    @Test
    void isNotAbleToMove() {
    	MoveStrategy dice = new DiceStrategy(UNDER_FOUR_SUPPLIER);
        assertThat(dice.isAbleToMove()).isFalse();
    }

    @DisplayName("4이상의  supplier 값이 들어오면 true 리턴한다.")
    @Test
    void isAbleToMove() {
	    MoveStrategy dice = new DiceStrategy(EQUAL_OR_OVER_FOUR_SUPPLIER);
        assertThat(dice.isAbleToMove()).isTrue();
    }

}
