package study.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.racingcar.strategy.CarMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class CarMoveStrategyTest {

    @DisplayName("MoveStrategy 4이상이면 TRUE 반환 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9,10})
    public void CarMoveStrategy_isMove_TRUE(int boundNum) {

        CarMoveStrategy carMoveStrategy = new CarMoveStrategy(new ReturnOnlyRandomNumber(boundNum));

        assertThat(carMoveStrategy.isMove()).isTrue();
    }

    @DisplayName("MoveStrategy 3이하이면 FALSE 반환 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    public void CarMoveStrategy_isMove_FALSE(int boundNum) {

        CarMoveStrategy carMoveStrategy = new CarMoveStrategy(new ReturnOnlyRandomNumber(boundNum));

        assertThat(carMoveStrategy.isMove()).isFalse();
    }
}
