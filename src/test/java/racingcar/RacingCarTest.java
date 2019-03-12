package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class RacingCarTest {

    @Test
    public void test_checkCanMoveTrue() {
        // Given
        int num = 4;

        // When
        boolean canMove = RacingCar.checkCanMove(num);

        // Then
        assertThat(canMove).isEqualTo(true);
    }

    @Test
    public void test_checkCanMoveFalse() {
        // Given
        int num = 10;

        // When
        boolean canMove = RacingCar.checkCanMove(num);

        // Then
        assertThat(canMove).isEqualTo(false);
    }

    @Test
    public void test_makeRandomMove() {
        // Given
        RacingCar racingCar = new RacingCar();

        // When
        int position1 = racingCar.makeRandomMove();
        int position2 = racingCar.makeRandomMove();

        // Then
        assertThat(position1).isLessThanOrEqualTo(position2);
    }
}