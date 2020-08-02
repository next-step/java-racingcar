package step3.stretegy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class DiceTest {

    private static final Supplier<Integer> UNDER_FOUR_SUPPLIER = () -> 3;
    private static final Supplier<Integer> EQUAL_OR_OVER_FOUR_SUPPLIER = () -> 4;

    private final Dice dice = new Dice();

    @DisplayName("10만번 random 값을 뽑는 것 모두 0-9 사이의 값이어야 한다.")
    @Test
    void attemptMove() {
        Integer givenStart = 0;
        Integer givenEnd = 100000;
        IntStream.range(givenStart,givenEnd).forEach(index -> assertThat(dice.attemptMove().get()).isBetween(0,9));
    }

    @DisplayName("4 미만의 supplier 값이 들어오면 false 리턴한다.")
    @Test
    void isNotAbleToMove() {
        assertThat(dice.isAbleToMove(UNDER_FOUR_SUPPLIER)).isFalse();
    }

    @DisplayName("4이상의  supplier 값이 들어오면 true 리턴한다.")
    @Test
    void isAbleToMove() {
        assertThat(dice.isAbleToMove(EQUAL_OR_OVER_FOUR_SUPPLIER)).isTrue();
    }

}