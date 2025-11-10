package racingCar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarRaceTest {
    @Test
    void 입력받은_대수만큼_할당() {
        assertThat(new CarRace(3).getCars().size()).isEqualTo(3);
    }

    @Test
    void 자동차들_이동_시도() {
        CarRace carRace = new CarRace(3);

        carRace.play();

        List<Car> cars = carRace.getCars();

        assertTrue(cars.get(0).getDistance() == 0 || cars.get(0).getDistance() == 1);
        assertTrue(cars.get(1).getDistance() == 0 || cars.get(1).getDistance() == 1);
        assertTrue(cars.get(2).getDistance() == 0 || cars.get(2).getDistance() == 1);
    }
}
