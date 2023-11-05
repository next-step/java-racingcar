package racinggame.factory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.Car;
import racinggame.strategy.MoveStrategy;
import racinggame.strategy.TestMove;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FactoryCarTest {

    @Test
    @DisplayName("성공 - 자동차 대수 만큼 position 값이 0인 자동차를 생성한다.")
    void success_generate_cars() {
        // given
        MoveStrategy moveStrategy = new TestMove(0);
        FactoryCar factoryCar = new FactoryCar();
        List<String> carNames = List.of("a", "b", "c");

        // when
        List<Car> cars = factoryCar.generateCar(carNames, moveStrategy);

        //then
        assertThat(cars).hasSize(carNames.size())
                .extracting("position")
                .containsOnly(0, 0, 0);
    }

}