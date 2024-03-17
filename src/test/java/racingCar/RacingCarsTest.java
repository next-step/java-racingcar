package racingCar;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarsTest {

    RacingCar pobi;
    RacingCar crong;
    RacingCar honux;

    MoveRule moveRule = new MoveRule();

    @BeforeEach
    void init() {
        pobi = new RacingCar(new CarName("pobi"), new Location(0));
        crong = new RacingCar(new CarName("crong"), new Location(1));
        honux = new RacingCar(new CarName("honux"), new Location(5));
    }

    @Test
    @DisplayName("다수의 차 움직임 테스트")
    void MultipleCars_MovingTest() {
        RacingCars cars = new RacingCars(List.of(pobi, crong, honux), moveRule);
        cars.moveCars();

        RacingCars moveCars = new RacingCars(List.of(
            new RacingCar(new CarName("pobi"), new Location(1)),
            new RacingCar(new CarName("crong"), new Location(2)),
            new RacingCar(new CarName("honux"), new Location(6))),
            moveRule);

        Assertions.assertThat(cars).isEqualTo(moveCars);
    }

    private static class MoveRule implements RacingRule {

        @Override
        public boolean isMovable() {
            return true;
        }
    }
}
