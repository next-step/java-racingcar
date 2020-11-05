package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class CarRacingTest {

    @Test
    @DisplayName("자동차 경주는 경주결과를 출력하는 ResultView를 받을 수 있다.")
    void acceptableResultView() {
        CarRacing carRacing = new CarRacing(new RacingInput(3, 3), new ResultView());
        assertDoesNotThrow(() -> carRacing.run());
    }
}