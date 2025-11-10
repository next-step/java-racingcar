package racingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

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

        assertThat(cars.get(0).getPosition()).isBetween(0,10);
        assertThat(cars.get(1).getPosition()).isBetween(0,10);
        assertThat(cars.get(2).getPosition()).isBetween(0,10);
    }
}
