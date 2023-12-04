package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;
import racingcar.model.movestrategy.AlwaysMoveStrategy;
import racingcar.model.movestrategy.AlwaysStopStrategy;
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
    @DisplayName("전진 시 Position 값이 1씩 변경")
    public void 전진_여부_확인() {
        RacingCar car1 = new RacingCar(new AlwaysMoveStrategy(), "abc");
        car1.moveOrStop();
        assertThat(car1.position())
                .isEqualTo(new Position(1));
    }

}
