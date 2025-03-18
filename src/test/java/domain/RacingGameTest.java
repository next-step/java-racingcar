package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RacingGameTest {

    @DisplayName("자동차의 수 또는 시도 횟수가 0보다 작은 경우 IllegalArgumentException 발생")
    @ParameterizedTest
    @CsvSource(value = {"0, 1", "1, 0", "0, 0", "-1, 1", "1, -1", "-1, -1"})
    void test(Integer numberOfCar, Integer numberOfRacing) {
        // When & Then
        Assertions.assertThatThrownBy(() -> {
            new RacingGame(numberOfCar, numberOfRacing);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}