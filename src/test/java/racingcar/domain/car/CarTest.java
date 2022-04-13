package racingcar.domain.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.strategy.MoveStrategy;
import racingcar.domain.car.strategy.StopStrategy;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 경주 - Car 테스트")
public class CarTest {
    private Car car;
    private final int DEFAULT_POSITION = 0;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    void 자동차는_전진한다() {
        car.act(new MoveStrategy());
        assertThat(car.getPosition()).isEqualTo(DEFAULT_POSITION + 1);
    }

    @Test
    void 자동차는_멈춘다() {
        car.act(new StopStrategy());
        assertThat(car.getPosition()).isEqualTo(DEFAULT_POSITION);
    }

    @Test
    void 자동차는_현재_위치를_나타낸다() {
        assertThat(car.getPosition()).isEqualTo(DEFAULT_POSITION);
    }

    @Test
    void 자동차는_전진하면_위치가_1_증가한다() {
        car.goForward();
        assertThat(car.getPosition()).isEqualTo(DEFAULT_POSITION + 1);
    }
}
