package racingcar.domain;

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
    public void test_checkMovableFalse_MIN() {
        // Given
        int num = 3;

        // When
        boolean canMove = RacingCar.checkMovable(num);

        // Then
        assertThat(canMove).isEqualTo(false);
    }

    @Test
    public void test_checkMovableFalse_MAX() {
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
        RacingCar car = new RacingCar("tomato");

        // When
        int position1 = car.moveRandomly();
        int position2 = car.moveRandomly();

        // Then
        assertThat(position1).isLessThanOrEqualTo(position2);
    }

    @Test
    public void test_compareTo() {
        // Given
        RacingCar car1 = new RacingCar("apple");
        RacingCar car2 = new RacingCar("banana");

        // When
        int gap = car1.moveRandomly() - car2.moveRandomly();
        int compareTo = car1.compareTo(car2);

        // Then
        assertThat(gap > 0).isEqualTo(compareTo > 0);
    }

    @Test
    public void test_equals() {
        // Given
        RacingCar car1 = new RacingCar("pobi", 2);
        RacingCar car2 = new RacingCar("pobi", 2);

        // When
        boolean result = car1.equals(car2);

        // Then
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void test_compareRacingCarList() {
        // Given
        final List<RacingCar> cars1 = Arrays.asList(
                new RacingCar("pobi", 2),
                new RacingCar("honux", 1),
                new RacingCar("crong", 5));

        final List<RacingCar> cars2 = Arrays.asList(
                new RacingCar("pobi", 2),
                new RacingCar("honux", 1),
                new RacingCar("crong", 5));

        // When
        boolean result = cars1.equals(cars2);

        // Then
        assertThat(result).isEqualTo(true);
    }
}