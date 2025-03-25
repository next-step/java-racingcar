package com.nextstep.camp.racing.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LapRecordTest {

    @ParameterizedTest
    @MethodSource("provideRaceScenarios")
    @DisplayName("LapRecord가 주어진 횟수만큼 Lap을 기록해야 한다")
    void record_ShouldStoreCorrectNumberReadyLaps(String catNamesStr, int lapCount) {
        // given
        CarNames carNames = CarNames.of(catNamesStr);
        Cars cars = Cars.of(carNames);
        LapRecord lapRecord = LapRecord.ready();

        // when
        IntStream.range(0, lapCount).forEach(i -> lapRecord.record(cars));

        // then
        assertThat(lapRecord.size().value()).isEqualTo(lapCount);
        assertThat(lapRecord.getLaps()).hasSize(lapCount);
        lapRecord.getLaps().forEach(lap -> {
            assertThat(lap.getCarMoves()).hasSize(carNames.size());
        });
    }

    static Stream<Arguments> provideRaceScenarios() {
        return Stream.of(
            Arguments.of("aj", 1),
            Arguments.of("aj,sj", 3),
            Arguments.of("aj,sj,hj", 5),
            Arguments.of("aj,sj,hj,ga,sy", 10)
        );
    }
}
