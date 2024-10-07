package racingGame.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RacingGameTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5, 6, 7})
    @DisplayName("생성자 메소드는 항상 객체를 생성한다.")
    void 생성자_성공_테스트() {
        assertDoesNotThrow(() -> new RacingGame());
    }

}
