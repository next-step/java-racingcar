package racing;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.RacingCar;
import racing.strategy.MoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    @DisplayName("자동차 생성")
    void create() {
        RacingCar actual = new RacingCar();
        assertThat(actual).isNotNull();
    }

    @ParameterizedTest(name = "{displayName} - 값: {0}")
    @ValueSource(ints = {0, 3, 4, 9})
    @DisplayName(("자동차 전진 테스트"))
    void ongoing(int randomValue) {
        RacingCar car = new RacingCar();
        MoveStrategy moveStrategy = new FixedRandomForwardStrategy(randomValue);
        car.setMoveStrategy(moveStrategy);
        car.move();

        int actual = car.getPosition();
        if (randomValue >= 4) {
            assertThat(actual).isEqualTo(1);
        } else {
            assertThat(actual).isEqualTo(0);
        }
    }
}

