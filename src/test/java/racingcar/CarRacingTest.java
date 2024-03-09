package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarRacingTest {

    @Test
    @DisplayName("자동차 수와 횟수가 0이거나 음수일 때")
    public void 자동차0대_0회() {
        CarRacing.Racing();
    }
}