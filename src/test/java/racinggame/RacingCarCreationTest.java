package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.racingcar.MoveStrategy;
import racinggame.racingcar.RacingCars;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarCreationTest {

    @Test
    @DisplayName("단일 자동차 객체 생성")
    void singleCarCreation() {
        RacingCars racingCars = new RacingCars();
        MoveStrategy dummyStrategy = () -> false;

        racingCars.addCar(dummyStrategy);

        assertThat(racingCars.count()).isEqualTo(1);
        assertThat(racingCars.allCarsAtStartPosition()).isTrue();
    }

    @Test
    @DisplayName("여러 대의 자동차 객체 생성")
    void multipleCarCreation() {
        RacingCars racingCars = new RacingCars();
        MoveStrategy dummyStrategy = () -> false;

        racingCars.addCar(dummyStrategy);
        racingCars.addCar(dummyStrategy);
        racingCars.addCar(dummyStrategy);

        assertThat(racingCars.count()).isEqualTo(3);
        assertThat(racingCars.allCarsAtStartPosition()).isTrue();
    }
}
