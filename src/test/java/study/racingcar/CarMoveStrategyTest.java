package study.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarMoveStrategyTest {

    @DisplayName("MoveStrategy 정상 수행 테스트")
    @Test
    public void CarMoveStrategy_move() {

        CarMoveStrategy carMoveStrategy = new CarMoveStrategy();

        assertThat(carMoveStrategy.isMove());
    }
}
