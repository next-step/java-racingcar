package domain;

import movingStrategy.AlwaysMove;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;

class RacingGameTest {

    @DisplayName("자동차의 수 또는 시도 횟수가 0보다 큰 경우 예외 발생하지 않음")
    @Test
    void startTest() {
        // Given
        int validTryCount = 5;
        String[] validNamesOfCar = {"more", "much", "less"};

        // When
        RacingGame racingGame = new RacingGame(validNamesOfCar, validTryCount, new AlwaysMove());

        // Then
        assertThatNoException().isThrownBy(racingGame::start);
    }
}