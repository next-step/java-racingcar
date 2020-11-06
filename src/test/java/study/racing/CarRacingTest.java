package study.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class CarRacingTest {

    @Test
    @DisplayName("자동차 레이싱 결과에 에러가 없다.")
    void acceptableResultView() {
        CarRacing carRacing = new CarRacing(new RacingInput(3, 3), new ResultView());
        assertDoesNotThrow(() -> carRacing.run());
    }
}
