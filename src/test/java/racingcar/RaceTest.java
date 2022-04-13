package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {
    @Test
    void createThreeCars() {
        Race race = new Race();
        assertThat(race.createCars(3)).hasSize(3);
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
        assertThat(car.getTrack()).hasSize(2);
    }

    @Test
    void rollTest() {
        Car car = new Car();
        RolledResult movedResult = Race.roll(car);
        if (movedResult.isMoved) {
            assertThat(movedResult.car.getTrack()).hasSize(2);
        } else {
            assertThat(movedResult.car.getTrack()).hasSize(1);
        }
    }
}
