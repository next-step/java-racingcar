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

    @BeforeEach
    void init() {
        pobi = new RacingCar(new CarName("pobi"));
        crong = new RacingCar(new CarName("crong"));
        honux = new RacingCar(new CarName("honux"));
    }

    @Test
    @DisplayName("가장 멀리간 위치가 1일 때")
    void FarthestLocation_Is_One() {
        pobi.move(true);
        crong.move(false);
        honux.move(false);
        RacingCars cars = new RacingCars(List.of(pobi, crong, honux));

        Assertions.assertThat(cars.findFarthestLocation()).isEqualTo(1);
    }

    @Test
    @DisplayName("가장 멀리간 위치가 5일 때")
    void FarthestLocation_Is_Five() {
        pobi.move(true);
        pobi.move(true);
        pobi.move(true);
        pobi.move(true);
        pobi.move(true);

        RacingCars cars = new RacingCars(List.of(pobi, crong, honux));

        Assertions.assertThat(cars.findFarthestLocation()).isEqualTo(5);
    }

}
