package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.Constants;
import racingcar.strategy.DoOneForward;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @BeforeEach
    Car car = new Car();

    //핵심로직/UI로직 테스트와 무관한 테스트 꼭 확인
    @DisplayName("Car 초기 position 0에서 시작")
    @Test
    public void assertCarInitPositionIsZero() {
        assertThat(car.getPosition()).isEqualTo(Constants.INIT_POSITION);
    }

    @DisplayName("Car 가능한 Strategy 모두 전진 1 or 멈춤 0")
    @Test
    public void assertCarStrategyOnlyForwardOrStop() {
        car.setDoRace(new DoOneForward());
       assertThat(car.move()).is(0 || 1);
    }
}
