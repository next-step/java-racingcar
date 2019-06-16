package com.jaeyeonling.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RacingGameOptionTest {

    @DisplayName("RacingGameOption 객체 생성")
    @Test
    void createOption() {
        assertThat(RacingGameOption.builder().build()).isNotNull();
    }

    @DisplayName("numberOfParticipants 값에 0 입력 시 예외처리")
    @Test
    void zeroNumberOfParticipants() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> RacingGameOption.builder().numberOfParticipants(0));
    }

    @DisplayName("numberOfParticipants 값에 범위를 초과하는 입력 시 예외처리")
    @ParameterizedTest
    @ValueSource(ints = { 456645, 745567, 3462352, 235252 })
    void overNumberOfParticipants(final int overNumber) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> RacingGameOption.builder().numberOfParticipants(overNumber));
    }

    @DisplayName("numberOfParticipants 값에 음수 값 입력 시 예외처리")
    @ParameterizedTest
    @ValueSource(ints = { -1, -23, -523, -4353, -45645 })
    void negativeNumberOfParticipants(final int negativeNumber) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> RacingGameOption.builder().numberOfParticipants(negativeNumber));
    }

    @DisplayName("movingCount 값에 0 입력 시 예외처리")
    @Test
    void zeroMovingCount() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> RacingGameOption.builder().movingCount(0));
    }

    @DisplayName("movingCount 값에 범위를 초과하는 입력 시 예외처리")
    @ParameterizedTest
    @ValueSource(ints = { 456645, 745567, 3462352, 235252 })
    void overMovingCount(final int overNumber) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> RacingGameOption.builder().movingCount(overNumber));
    }

    @DisplayName("movingCount 값에 음수 값 입력 시 예외처리")
    @ParameterizedTest
    @ValueSource(ints = { -1, -23, -523, -4353, -45645 })
    void negativeMovingCount(final int negativeNumber) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> RacingGameOption.builder().movingCount(negativeNumber));
    }

    @DisplayName("moveStrategy 값에 null 입력 시 예외처리")
    @Test
    void nullMoveStrategy() {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> RacingGameOption.builder().moveStrategy(null));
    }
}
