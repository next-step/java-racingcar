package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {
    @Test
    void createThreeCars() {
        Race race = new Race();
        String[] carNames = {"pobi", "crong", "honux"};
        assertThat(race.createCars(carNames)).hasSize(3);
    }
    
    @Test
    void CarShouldMove() {
        Car car = new Car("test");
        car.move();
        assertThat(car.getTrack()).hasSize(2);
    }

    @Test
    void rollTest() {
        Car car = new Car("test");
        RolledResult movedResult = Race.roll(car);
        if (movedResult.isMoved) {
            assertThat(movedResult.car.getTrack()).hasSize(2);
        } else {
            assertThat(movedResult.car.getTrack()).hasSize(1);
        }
    }
}
