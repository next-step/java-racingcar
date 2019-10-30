package project.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car alwaysCanMoveCar;
    private Car alwaysCannotMoveCar;

    private int winnerScore;

    @BeforeEach
    void setUp() {
        MoveRule mAlwaysCanMoveRule = new RandomlyMoveRule(() -> 4);
        MoveRule mAlwaysCannotMoveRule = new RandomlyMoveRule(() -> 3);

        alwaysCanMoveCar = new Car("one", mAlwaysCanMoveRule);
        alwaysCannotMoveCar = new Car("two", mAlwaysCannotMoveRule);

        winnerScore = 5;
    }

    @Test
    void isMovingCarTest() {
        assertThat(alwaysCanMoveCar.moveIfPossible()).isGreaterThan(1);
        assertThat(alwaysCannotMoveCar.moveIfPossible()).isEqualTo(1);
    }

    @Test
    void winnerCarTest() {
        alwaysCanMoveCar.moveIfPossible();
        alwaysCanMoveCar.moveIfPossible();
        alwaysCanMoveCar.moveIfPossible();
        alwaysCanMoveCar.moveIfPossible();

        assertThat(alwaysCanMoveCar.canBeWinner(winnerScore)).isTrue();
    }
}
