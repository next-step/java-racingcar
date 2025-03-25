package com.nextstep.camp.racing.domain.entity;

import java.util.stream.Stream;

import com.nextstep.camp.racing.common.vo.PositiveInteger;
import com.nextstep.camp.racing.domain.vo.CarNames;
import com.nextstep.camp.racing.domain.vo.Cars;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {

    private Cars cars;
    private Racing racing;
    private PositiveInteger lapCount;

    @BeforeEach
    void setUp() {
        CarNames carNames = CarNames.of("car1,car2,car3,car4,car5");
        this.cars = Cars.of(carNames);
        this.lapCount = PositiveInteger.of("3");
        this.racing = Racing.initialize(cars, lapCount);
    }

    @Test
    void initialize_ShouldCreateRacingObject() {
        assertThat(racing).isNotNull();
        assertThat(racing.getCars()).isNotNull();
        assertThat(racing.getCars().size()).isEqualTo(cars.size());
    }

    @ParameterizedTest
    @MethodSource("provideCarQuantitiesAndLapCount")
    void initialize_WithDifferentValues_ShouldCreateRacingObject(String carNamesStr, String lapCountStr) {
        CarNames carNames = CarNames.of(carNamesStr);
        Cars cars = Cars.of(carNames);
        PositiveInteger lapCount = PositiveInteger.of(lapCountStr);

        Racing racing = Racing.initialize(cars, lapCount);

        assertThat(racing).isNotNull();
        assertThat(racing.getCars()).isNotNull();
        assertThat(racing.getCars().size()).isEqualTo(cars.size());
    }

    static Stream<Arguments> provideCarQuantitiesAndLapCount() {
        return Stream.of(
                Arguments.of("aj", "3"),
                Arguments.of("sj,hj", "10"),
                Arguments.of("aj,sj,hj", "20")
        );
    }

    @Test
    void start_ShouldRecordCorrectLapCount() {
        // when
        racing.start();

        // then
        assertThat(racing.getLaps()).hasSize(lapCount.value());
    }

    @Test
    void start_ShouldDetermineWinners() {
        // when
        racing.start();

        // then
        assertThat(racing.getWinners()).isNotNull();
        assertThat(racing.getWinners().size()).isGreaterThan(0);
    }

    @Test
    void start_ShouldPreserveCarCountAfterRace() {
        // when
        racing.start();

        // then
        assertThat(racing.getCars().size()).isEqualTo(cars.size());
    }
}
