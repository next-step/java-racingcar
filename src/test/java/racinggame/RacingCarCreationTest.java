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
        MoveStrategy dummyStrategy = () -> false;
        RacingCars racingCars = RacingCars.create(1, dummyStrategy);

        assertThat(racingCars.count()).isEqualTo(1);
        assertThat(racingCars.getCurrentPositionsRepresentation()).containsOnly(0);
    }

    @Test
    @DisplayName("여러 대의 자동차 객체 생성")
    void multipleCarCreation() {
        MoveStrategy dummyStrategy = () -> false;
        RacingCars racingCars = RacingCars.create(3, dummyStrategy);

        assertThat(racingCars.count()).isEqualTo(3);
        assertThat(racingCars.getCurrentPositionsRepresentation()).containsOnly(0);
    }
}
