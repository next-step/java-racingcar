package racingcar.domain.vehicle;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.engine.Engine;

@DisplayName("[Step4] 자동차들")
class CarsTest {

    @DisplayName("[성공] 추가")
    @ParameterizedTest
    @ValueSource(strings = "pobi,crong,honux,hyune")
    public void add(String carNameString) {
        // given
        Cars cars = CarsFactory.create(carNameString);

        // when

        // then
        assertThat(cars.getCars().size()).isEqualTo(4);
    }

    @DisplayName("[성공] 우승")
    @ParameterizedTest
    @ValueSource(strings = "pobi,crong,honux,hyune")
    public void winners(String carNameString) {
        // given
        Engine allwaysMoveEngine = () -> 9;

        Cars cars = CarsFactory.create(carNameString);
        cars.add(CarFactory.create(allwaysMoveEngine, "win1"));
        cars.add(CarFactory.create(allwaysMoveEngine, "win2"));

        // when
        for (int i = 0; i < 100; i++) {
            cars.doDrive();
        }

        // then
        assertThat(cars.getWinnerNames().toString()).contains("win1", "win2");
    }
}
