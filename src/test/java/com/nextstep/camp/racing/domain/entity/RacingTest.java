package com.nextstep.camp.racing.domain.entity;

import java.util.stream.Stream;

import com.nextstep.camp.racing.common.vo.PositiveInteger;
import com.nextstep.camp.racing.domain.vo.Cars;
import com.nextstep.camp.racing.domain.vo.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {

    private Racing racing;
    private PositiveInteger carQuantity;
    private PositiveInteger maxPosition;

    @BeforeEach
    void setUp() {
        carQuantity = PositiveInteger.of("5");
        maxPosition = PositiveInteger.of("3");
        racing = Racing.initialize(carQuantity, maxPosition);
    }

    @Test
    void initialize_ShouldCreateRacingObject() {
        assertThat(racing).isNotNull();
        assertThat(racing.getCars()).isNotNull();
        assertThat(racing.getCars().size()).isEqualTo(carQuantity.value());
    }

    @ParameterizedTest()
    @MethodSource("provideCarQuantitiesAndMaxPositions")
    void initialize_WithDifferentValues_ShouldCreateRacingObject(String carQuantityStr, String maxPositionStr) {
        PositiveInteger carQuantity = PositiveInteger.of(carQuantityStr);
        PositiveInteger maxPosition = PositiveInteger.of(maxPositionStr);

        Racing racing = Racing.initialize(carQuantity, maxPosition);

        assertThat(racing).isNotNull();
        assertThat(racing.getCars()).isNotNull();
        assertThat(racing.getCars().size()).isEqualTo(carQuantity.value());
    }

    static Stream<Arguments> provideCarQuantitiesAndMaxPositions() {
        return Stream.of(
            Arguments.of("1", "3"),
            Arguments.of("5", "10"),
            Arguments.of("10", "20")
        );
    }

    @Test
    void start_ShouldMoveCars() {
        Cars beforeMove = racing.getCars().copy();

        racing.start();

        Cars afterMove = racing.getCars();
        assertThat(afterMove.getMaxPosition()).isEqualTo(Position.of(maxPosition));
        assertThat(afterMove).isNotEqualTo(beforeMove);
    }

    @ParameterizedTest
    @MethodSource("provideRaceScenarios")
    void start_WithDifferentScenarios_ShouldMoveCars(String carQuantityStr, String maxPositionStr) {
        PositiveInteger carQuantity = PositiveInteger.of(carQuantityStr);
        PositiveInteger maxPosition = PositiveInteger.of(maxPositionStr);
        Racing racing = Racing.initialize(carQuantity, maxPosition);
        Cars beforeMove = racing.getCars().copy();

        racing.start();

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
