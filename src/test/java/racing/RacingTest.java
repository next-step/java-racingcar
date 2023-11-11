package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RacingTest {

    @DisplayName("자동차 이름 배열을 받아서 레이싱을 생성할 수 있다.")
    @Test
    void racingCreateTest() {
        String[] carNames = {"test1", "test2", "test3"};
        Racing racing = new Racing(carNames, 0);
        assertThat(racing.getCars().getSize()).isEqualTo(3);
    }
}