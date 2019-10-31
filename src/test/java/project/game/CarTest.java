package project.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.game.domain.Car;
import project.game.domain.MoveRule;
import project.game.domain.RandomlyMoveRule;

import static org.assertj.core.api.Assertions.assertThat;
import static project.game.TextConstant.RACING_CAR_POSITION_TEXT;

public class CarTest {

    private Car alwaysCanMoveCar;
    private Car alwaysCannotMoveCar;

    private int winnerScore;

    @BeforeEach
    void setUp() {
        MoveRule mAlwaysCanMoveRule = new RandomlyMoveRule(() -> 4);
        MoveRule mAlwaysCannotMoveRule = new RandomlyMoveRule(() -> 3);

        alwaysCanMoveCar = new Car("alwaysCanMoveCar", mAlwaysCanMoveRule);
        alwaysCannotMoveCar = new Car("alwaysCannotMoveCar", mAlwaysCannotMoveRule);

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

        assertThat(alwaysCanMoveCar.hasEqualPositionTo(winnerScore)).isTrue();
    }

    @Test
    void carPositionTest() {
        int moveCount = 4;
        for (int i = 0; i < moveCount; i++) {
            alwaysCanMoveCar.moveIfPossible();
        }

        String positionLine = StringUtils.createRepeatedCharacter(moveCount + 1, '-');
        assertThat(alwaysCanMoveCar.getCurrentPositionText()).isEqualTo(String.format(RACING_CAR_POSITION_TEXT, "alwaysCanMoveCar", positionLine));
    }
}
