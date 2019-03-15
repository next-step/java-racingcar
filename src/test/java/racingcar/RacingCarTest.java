package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class RacingCarTest {

    @Test
    public void test_checkMovableTrue() {
        // Given
        int num = 4;

        // When
        boolean canMove = RacingCar.checkMovable(num);

        // Then
        assertThat(canMove).isEqualTo(true);
    }

    @Test
    public void test_checkMovableFalse() {
        // Given
        int num = 10;

        // When
        boolean canMove = RacingCar.checkMovable(num);

        // Then
        assertThat(canMove).isEqualTo(false);
    }

    @Test
    public void test_moveRandomly() {
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

    @Test
    public void test_equals() {
        // Given
        RacingCar racingCar1 = new RacingCar("pobi", 2);
        RacingCar racingCar2 = new RacingCar("pobi", 2);

        // When
        boolean result = racingCar1.equals(racingCar2);

        // Then
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void test_compareRacingCarList() {
        // Given
        final List<RacingCar> racingCars1 = Arrays.asList(
                new RacingCar("pobi", 2),
                new RacingCar("honux", 1),
                new RacingCar("crong", 5));

        final List<RacingCar> racingCars2 = Arrays.asList(
                new RacingCar("pobi", 2),
                new RacingCar("honux", 1),
                new RacingCar("crong", 5));

        // When
        boolean result = racingCars1.equals(racingCars2);

        // Then
        assertThat(result).isEqualTo(true);
    }
}