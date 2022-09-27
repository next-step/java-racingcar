package step3.car_racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingTest {

    @Test
    @DisplayName("racing 실행 시 랜덤 값에 따라 전진 한다.")
    void racing() {
        // given
        Racing racing = new Racing();

        // when
        racing.race(3, 2);

        //then
    }
}