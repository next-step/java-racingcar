package racingcar.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarInfoTest {

    @Test
    @DisplayName("1개 미만의 숫자를 입력했을 경우 오류가 발생한다.")
    void creatCarInfo_1개미만() {
        assertThatThrownBy(() -> new CarInfo(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 1개 이상의 자동차를 만들어야합니다.");
    }
}