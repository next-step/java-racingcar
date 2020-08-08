package step3.logic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class CarMovementTest {

    @RepeatedTest(10)
    @DisplayName("자동차 전진, 정지 확인 로직")
    void isCarGoingForward() {
        assertThat(CarMovement.isCarGoingForward()).isFalse();
    }
}