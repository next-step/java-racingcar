package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarListTest {

    @DisplayName("예외 발생 테스트 - NullPointerException")
    @Test
    public void test() {
        assertThatThrownBy(() -> {
            RacingCarList racingCarList = new RacingCarList(-1);
            racingCarList.moveCars(null);
        }).isInstanceOf(NullPointerException.class);
    }
}
