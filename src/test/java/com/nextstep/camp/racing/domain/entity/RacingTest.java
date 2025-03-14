package com.nextstep.camp.racing.domain.entity;

import com.nextstep.camp.racing.common.vo.PositiveInteger;
import com.nextstep.camp.racing.domain.vo.Cars;
import com.nextstep.camp.racing.domain.vo.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class RacingTest {

    private Racing racing;
    private PositiveInteger carQuantity;
    private PositiveInteger maxPosition;

    @BeforeEach
    void setUp() {
        carQuantity = PositiveInteger.of("3");
        maxPosition = PositiveInteger.of("5");
        racing = Racing.initialize(carQuantity, maxPosition);
    }

    @Test
    void initialize_ShouldCreateRacingObject() {
        // Then
        assertThat(racing).isNotNull();
        assertThat(racing.getCars()).isNotNull();
        assertThat(racing.getCars().size()).isEqualTo(carQuantity.value());
    }

    @ParameterizedTest()
    @MethodSource("provideCarQuantitiesAndMaxPositions")
    void initialize_WithDifferentValues_ShouldCreateRacingObject(String carQuantityStr, String maxPositionStr) {
        // Given
        PositiveInteger carQuantity = PositiveInteger.of(carQuantityStr);
        PositiveInteger maxPosition = PositiveInteger.of(maxPositionStr);

        // When
        Racing racing = Racing.initialize(carQuantity, maxPosition);

        // Then
        assertThat(racing).isNotNull();
        assertThat(racing.getCars()).isNotNull();
        assertThat(racing.getCars().size()).isEqualTo(carQuantity.value());
    }

    static Stream<Arguments> provideCarQuantitiesAndMaxPositions() {
        return Stream.of(
            Arguments.of("1", "3"),  // 최소값 테스트
            Arguments.of("5", "10"), // 일반적인 값
            Arguments.of("10", "20") // 최대값 테스트
        );
    }

    @Test
    void start_ShouldMoveCars() {
        // Given
        Cars beforeMove = racing.getCars().copy(); // 기존 상태 저장

        // When
        racing.start();

        // Then
        Cars afterMove = racing.getCars();
        assertThat(afterMove.getMaxPosition()).isEqualTo(Position.of(maxPosition));
        assertThat(afterMove).isNotEqualTo(beforeMove); // 자동차의 위치가 변해야 함
    }

    @ParameterizedTest
    @MethodSource("provideRaceScenarios")
    void start_WithDifferentScenarios_ShouldMoveCars(String carQuantityStr, String maxPositionStr) {
        // Given
        PositiveInteger carQuantity = PositiveInteger.of(carQuantityStr);
        PositiveInteger maxPosition = PositiveInteger.of(maxPositionStr);
        Racing racing = Racing.initialize(carQuantity, maxPosition);
        Cars beforeMove = racing.getCars().copy();

        // When
        racing.start();

        // Then
        Cars afterMove = racing.getCars();
        assertThat(afterMove.getMaxPosition()).isEqualTo(Position.of(maxPosition));
        assertThat(afterMove).isNotEqualTo(beforeMove);
    }

    static Stream<Arguments> provideRaceScenarios() {
        return Stream.of(
            Arguments.of("3", "5"),
            Arguments.of("5", "10"),
            Arguments.of("7", "15")
        );
    }
}
