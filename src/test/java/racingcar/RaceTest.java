package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {
    @Test
    void createThreeCars() {
        assertThat(Race.createCars(3)).hasSize(3);
    }

    @Test
    void randomShouldBeZeroToNineAtLeastTenTimes() {
        for (int i = 0; i < 10; i++) {
            assertThat(Race.getRandom()).isBetween(0, 9);
        }
    }

    @Test
    void CarShouldMove() {
        Car car = new Car();
        car.move();
        assertThat(car.track).hasSize(2);
    }

    @Test
    void rollTest() {
        Car car = new Car();
        RolledResult movedResult = Race.roll(car);
        if (movedResult.isMoved) {
            assertThat(movedResult.car.track).hasSize(2);
        } else {
            assertThat(movedResult.car.track).hasSize(1);
        }
    }
}
