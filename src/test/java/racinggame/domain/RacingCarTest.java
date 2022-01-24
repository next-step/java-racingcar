package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    @Test
    void 자동차의_이름_글자수_5자_이하_실패() {
        String carName = "carcar1";

        assertThrows(IllegalArgumentException.class, () -> Validator.validateNameLength(carName));
    }

    @Test
    void 자동차의_이름_글자수_5자_이하_성공() {
        String carName = "car1";

        assertDoesNotThrow(() -> Validator.validateNameLength(carName));
    }

    @Test
    void 자동차_객체_생성() {
        RacingCar car = new RacingCar("car");

        assertThat(car.getCarName()).isEqualTo("car");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 한_칸_전진() {
        RacingCar car = new RacingCar("car");

        car.forward();

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void canForward_전진실패() {
        int randomValue = 1;
        RacingCar racingCar = new RacingCar("car1");

        assertFalse(racingCar.canForward(randomValue));
    }

    @Test
    void canForward_전진가능() {
        int randomValue = 5;
        RacingCar racingCar = new RacingCar("car1");

        assertTrue(racingCar.canForward(randomValue));
    }

    @Test
    void 자동차이름_배열을_받아_자동차객체_리스트_생성() {
        String[] carNames = {"car1", "car2"};

        List<RacingCar> racingCars = RacingCar.createRacingCarFromCarNames(carNames);

        assertEquals(racingCars.get(0).getCarName(), carNames[0]);
        assertEquals(racingCars.get(1).getCarName(), carNames[1]);
    }
}