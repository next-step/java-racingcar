package com.jaenyeong.mission2.racingcar.domain;

import com.jaenyeong.mission2.racingcar.common.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Car 객체의 경주 기록을 담당하는 RacingHistory 클래스 테스트")
class RacingHistoryTest extends BaseTest {

    @ParameterizedTest
    @MethodSource("randomIntValues")
    @DisplayName("RacingHistory 클래스 초기화 선언시 최초 턴 값은 항상 0임을 확인하는 테스트")
    void checkInitTurnValueEqualsZero(final int randomValue) {
        for (int i = 0; i < randomValue; i++) {
            final RacingHistory history = new RacingHistory();

            final int expectedInitTurnValue = 0;

            assertEquals(history.getCurrentTurn(), expectedInitTurnValue);
        }
    }

    @ParameterizedTest
    @MethodSource("randomIntValues")
    @DisplayName("RacingHistory 클래스 초기화 선언시 최초 턴 값은 항상 -1보다 크고 1보다 작은지 확인하는 테스트")
    void checkInitTurnValueEqualsNotNegativeAndGreaterThanOne(final int randomValue) {
        for (int i = 0; i < randomValue; i++) {
            final RacingHistory history = new RacingHistory();

            final int negative = -1;
            final int one = 1;

            assertThat(history.getCurrentTurn()).isGreaterThan(negative);
            assertThat(history.getCurrentTurn()).isLessThan(one);
        }
    }

    @ParameterizedTest
    @MethodSource("randomIntValues")
    @DisplayName("경주 데이터를 기록한 후 현재 턴에 기록된 데이터 유효성 확인 테스트")
    void checkRacingHistoryForCurrentTurnAfterWrite(final int randomValue) {
        final RacingHistory history = new RacingHistory();

        history.writeRaceDistanceHistory(randomValue);

        final int currentTurnRaceHistory = history.getRaceHistoryForCurrentTurn();

        assertEquals(randomValue, currentTurnRaceHistory);
    }

    @ParameterizedTest
    @MethodSource("randomIntValues")
    @DisplayName("경주 데이터를 임의의 횟수만큼 기록한 후 현재 턴에 기록된 데이터 유효성 확인 테스트")
    void checkRacingHistoryForCurrentTurnAfterWriteARandomNumberOfTimes(final int randomValue) {
        int currentDist = randomValue;

        final RacingHistory history = new RacingHistory();
        for (int i = 0; i < randomValue; i++) {
            currentDist++;

            history.writeRaceDistanceHistory(currentDist);
        }

        assertEquals(history.getRaceHistoryForCurrentTurn(), currentDist);
    }

    @ParameterizedTest
    @MethodSource("randomIntValues")
    @DisplayName("경주 데이터를 임의의 횟수만큼 기록한 후 특정 턴에 기록된 데이터 유효성 확인 테스트")
    void checkRacingHistoryForSpecificTurnAfterWrite(final int randomValue) {
        int currentDist = randomValue;

        final RacingHistory history = new RacingHistory();

        for (int i = 0; i < randomValue; i++) {
            currentDist++;

            history.writeRaceDistanceHistory(currentDist);

            assertEquals(history.getRaceHistoryForTurn(i + 1), currentDist);
        }
    }

    @ParameterizedTest
    @MethodSource("randomDistanceValues")
    @DisplayName("경주 데이터를 임의의 횟수만큼 기록한 후 기록된 모든 데이터 유효성 확인 테스트")
    void checkRacingHistoryForAllTurnAfterWrite(final List<Integer> randoms) {
        final RacingHistory history = new RacingHistory();

        for (int currentDist : randoms) {
            history.writeRaceDistanceHistory(currentDist);
        }

        assertThat(randoms).isEqualTo(history.getDistanceForAllTurn());
    }

    private static Stream<Arguments> randomDistanceValues() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)),
            Arguments.of(Arrays.asList(getRandomValue(), getRandomValue(), getRandomValue(), getRandomValue())),
            Arguments.of(Arrays.asList(
                getRandomValue(),
                getRandomValue(),
                getRandomValue(),
                getRandomValue(),
                getRandomValue(),
                getRandomValue(),
                getRandomValue()
            ))
        );
    }
}
