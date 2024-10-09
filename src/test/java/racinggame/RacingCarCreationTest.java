package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.strategy.MoveStrategy;
import racinggame.domain.racingcar.RacingCars;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarCreationTest {

    @Test
    @DisplayName("단일 자동차 객체 생성")
    void singleCarCreation() {
        MoveStrategy dummyStrategy = () -> false;
        List<String> nameList = List.of("a");
        RacingCars racingCars = RacingCars.create(dummyStrategy, nameList);

        Map<String, Integer> carInfo = racingCars.getCarsInfo();

        assertThat(racingCars.count()).isEqualTo(1);
        assertThat(carInfo).containsOnlyKeys("a");
        assertThat(carInfo.get("a")).isEqualTo(0);
    }

    @Test
    @DisplayName("여러 대의 자동차 객체 생성")
    void multipleCarCreation() {
        MoveStrategy dummyStrategy = () -> false;
        List<String> nameList = Arrays.asList("a", "b", "c");
        RacingCars racingCars = RacingCars.create(dummyStrategy, nameList);

        Map<String, Integer> carInfo = racingCars.getCarsInfo();

        assertThat(racingCars.count()).isEqualTo(3);
        assertThat(carInfo.keySet()).containsExactlyInAnyOrderElementsOf(nameList);
        assertThat(carInfo.values()).containsOnly(0);
    }
}
