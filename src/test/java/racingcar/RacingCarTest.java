package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;

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
        RacingCar car = new RacingCar("abc");
        car.moveOrStop(1);
        assertThat(car.getPosition())
                .isEqualTo(0);

        car.moveOrStop(4);
        assertThat(car.getPosition())
                .isEqualTo(1);
    }

}
