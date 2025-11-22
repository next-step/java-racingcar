package racingCar;

import org.junit.jupiter.api.Test;
import racingCar.domain.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarRaceTest {
    @Test
    void 입력받은_차량_대수() {
        CarRace carRace = new CarRace(new String[]{"pobi","crong","honux"}, 0);
        assertThat(carRace.getWinners().value()).hasSize(3);
    }

    @Test
    void 자동차들_이동_시도() {
        CarRace carRace = new CarRace(new String[]{"pobi","crong","honux"}, 1);

        carRace.play();

        List<Car> cars = carRace.getCars();

        assertTrue(cars.get(0).getDistance() == 0 || cars.get(0).getDistance() == 1);
        assertTrue(cars.get(1).getDistance() == 0 || cars.get(1).getDistance() == 1);
        assertTrue(cars.get(2).getDistance() == 0 || cars.get(2).getDistance() == 1);
    }

    @Test
    void 자동차_이름_부여() {
        CarRace carRace = new CarRace(new String[]{"pobi","crong","honux"},1);

        assertThat(carRace.getCars())
                .extracting(Car::getName)
                .containsExactly("pobi", "crong", "honux");
    }

    @Test
    void 자동차_이름_5초과_실패() {
        assertThatThrownBy(() -> new CarRace(new String[]{"janghojun"},1))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("이름이 5글자 초과되면 안됩니다.");
    }

}
