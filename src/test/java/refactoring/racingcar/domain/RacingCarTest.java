package refactoring.racingcar.domain;

import org.junit.jupiter.api.Test;
import refactoring.racingcar.domain.strategy.AlwaysMoveStrategy;
import refactoring.racingcar.domain.strategy.AlwaysStopStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @Test
    void 자동차_이름은_5자를_초과할_수_없다() {
        assertThatThrownBy(() -> new RacingCar(() -> true, "abcdef"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    void 자동차가_전진하면_위치가_1증가한다() {
        RacingCar racingCar = new RacingCar(new AlwaysMoveStrategy(), "abcd");
        racingCar.move();
        assertThat(racingCar.getPosition()).isEqualTo(new CarPosition(1));
    }

    @Test
    void 자동차가_멈추면_위치가_증가하지_않는다() {
        RacingCar racingCar = new RacingCar(new AlwaysStopStrategy(), "abcd");
        assertThat(racingCar.getPosition())
            .isEqualTo(new CarPosition(0));
    }
}
