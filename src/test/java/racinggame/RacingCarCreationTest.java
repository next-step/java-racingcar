package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.racingcar.CarName;
import racinggame.racingcar.CarPosition;
import racinggame.racingcar.MoveStrategy;
import racinggame.racingcar.RacingCars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarCreationTest {

    @Test
    @DisplayName("단일 자동차 객체 생성")
    void singleCarCreation() {
        MoveStrategy dummyStrategy = () -> false;
        List<String> nameList = List.of("a");
        RacingCars racingCars = RacingCars.create(1, dummyStrategy, nameList);

        assertThat(racingCars.count()).isEqualTo(1);
        assertThat(racingCars.getCarNames()).containsOnly("a");
        assertThat(racingCars.getCurrentPositionsRepresentation()).containsOnly(0);
    }

    @Test
    @DisplayName("여러 대의 자동차 객체 생성")
    void multipleCarCreation() {
        MoveStrategy dummyStrategy = () -> false;
        List<String> nameList = Arrays.asList("a", "b", "c");
        RacingCars racingCars = RacingCars.create(3, dummyStrategy, nameList);

        assertThat(racingCars.count()).isEqualTo(3);
        assertThat(racingCars.getCarNames()).isEqualTo(nameList);
        assertThat(racingCars.getCurrentPositionsRepresentation()).containsOnly(0);
    }
}
