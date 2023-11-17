package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;
import racingcar.model.movestrategy.VarMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    @DisplayName("자동차 이름은 5자 이하로 설정되어야 함")
    public void 자동차_이름_5자_이하() {
        Assertions.assertThatThrownBy(() -> new RacingCar("abcdefg"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("moveOrStop의 인수가 4 이상이면 전진, 미만이면 멈춤(location 변경 없음)")
    public void 전진_여부() {
        RacingCar car1 = new RacingCar(new VarMoveStrategy(3), "abc");
        car1.moveOrStop();
        assertThat(car1.position())
                .isEqualTo(new Position(0));

        RacingCar car2 = new RacingCar(new VarMoveStrategy(4), "abc");
        car2.moveOrStop();
        assertThat(car2.position())
                .isEqualTo(new Position(1));
    }

}
