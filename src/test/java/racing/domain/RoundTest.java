package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.strategy.MoveStrategy;
import racing.domain.strategy.ThresholdMoveStrategy;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RoundTest {

    @Test
    @DisplayName("자동차는 기준값 이상일 때만 이동한다.")
    void carMovesForwardWhenStrategyAllows() {
        MoveStrategy moveStrategy = new ThresholdMoveStrategy(() -> 5);
        Round round = new Round(1, moveStrategy);
        Cars cars = new Cars(new String[] {"Tesla", "BMW", "Audi"});

        round.execute(cars);

        Map<Car, Integer> carPositions = round.getCarPositions();
        for (Map.Entry<Car, Integer> carPosition : carPositions.entrySet()) {
            assertThat(carPosition.getValue()).isEqualTo(2);
        }
    }

    @Test
    @DisplayName("자동차는 기준값 미만일 때 이동하지 않는다.")
    void carStaysInPlaceWhenStrategyDisallows() {
        MoveStrategy moveStrategy = new ThresholdMoveStrategy(() -> 3);
        Round round = new Round(1, moveStrategy);
        Cars cars = new Cars(new String[] {"Tesla", "BMW", "Audi"});

        round.execute(cars);

        Map<Car, Integer> carPositions = round.getCarPositions();
        for (Map.Entry<Car, Integer> carPosition : carPositions.entrySet()) {
            assertThat(carPosition.getValue()).isEqualTo(1);
        }
    }

}
