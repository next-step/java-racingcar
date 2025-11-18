package racingCar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarRaceTest {
    @Test
    void 입력받은_차량_대수() {
        CarRace carRace = new CarRace(new String[]{"pobi","crong","honux"});
        assertThat(carRace.getWinners()).hasSize(3);
        assertThat(carRace.carNos()).isEqualTo(3);
    }

    @Test
    void 자동차들_이동_시도() {
        CarRace carRace = new CarRace(new String[]{"pobi","crong","honux"});

        carRace.play();

        List<Car> cars = carRace.getCars();

        assertTrue(cars.get(0).getDistance().equals(new Distance()) || cars.get(0).getDistance().equals(new Distance(1)));
        assertTrue(cars.get(1).getDistance().equals(new Distance()) || cars.get(1).getDistance().equals(new Distance(1)));
        assertTrue(cars.get(2).getDistance().equals(new Distance()) || cars.get(2).getDistance().equals(new Distance(1)));
    }

    @Test
    void 자동차_이름_부여() {
        CarRace carRace = new CarRace(new String[]{"pobi","crong","honux"});

        assertThat(carRace.getCars())
                .extracting(Car::getName)
                .containsExactly("pobi", "crong", "honux");
    }

    @Test
    void 자동차_이름_5초과_실패() {
        assertThatThrownBy(() -> new CarRace(new String[]{"janghojun"}))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("이름이 5글자 초과되면 안됩니다.");
    }

    @Test
    void 우승자_출력() {
        Car pobi = new Car(new Name("pobi"), new Distance(5));
        Car crong = new Car(new Name("crong"), new Distance(2));
        Car honux = new Car(new Name("honux"), new Distance(2));

        List<Car> cars = Arrays.asList(pobi, crong, honux);

        List<Car> winners = Winners.getWinners(cars);

        assertThat(winners).contains(pobi);
    }
}
