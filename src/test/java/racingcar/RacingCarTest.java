package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class RacingCarTest {

    @Test
    public void test_checkCanMoveTrue() {
        // Given
        int num = 4;

        // When
        boolean canMove = RacingCar.checkMovable(num);

        // Then
        assertThat(canMove).isEqualTo(true);
    }

    @Test
    public void test_checkCanMoveFalse() {
        // Given
        int num = 10;

        // When
        boolean canMove = RacingCar.checkMovable(num);

        // Then
        assertThat(canMove).isEqualTo(false);
    }

    @Test
    public void test_makeRandomMove() {
        // Given
        RacingCar racingCar = new RacingCar();

        // When
        int position1 = racingCar.moveRandomly();
        int position2 = racingCar.moveRandomly();

        // Then
        assertThat(position1).isLessThanOrEqualTo(position2);
    }

    @Test
    public void test_compareTo() {
        // Given
        RacingCar racingCar1 = new RacingCar();
        RacingCar racingCar2 = new RacingCar();

        // When
        int gap = racingCar1.moveRandomly() - racingCar2.moveRandomly();
        int compareTo = racingCar1.compareTo(racingCar2);

        // Then
        assertThat(gap > 0).isEqualTo(compareTo > 0);
    }
}