package racingCar.step5.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @DisplayName("자동차 이름은 5자 이하만 입력 가능하다")
    @Test
    void limitCarName(){
        assertThatThrownBy(() -> new RacingCar("123456"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름을 5자 이하로 입력해주세요.");
    }

}
