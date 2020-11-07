package study.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.racingcar.car.OldEngine;

import static org.junit.jupiter.api.Assertions.*;

class GameConfigurationTest {

    @Test
    @DisplayName("게임 설정 생성 성공")
    void test_createGameConfiguration_success() {
        // When & Then
        GameConfiguration gameConfiguration
                = new GameConfiguration("a", 1, OldEngine.getInstance());
    }

    @ParameterizedTest
    @CsvSource(value = {"123456|1", "|1", "a|0"}, delimiter = '|')
    void test_createGameConfiguration_fail(String carNamesWithComma, int numberOfAttempts) {
        assertThrows(IllegalArgumentException.class
                , () -> new GameConfiguration(carNamesWithComma, numberOfAttempts, OldEngine.getInstance()));
    }

}