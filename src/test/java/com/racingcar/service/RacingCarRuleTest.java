package com.racingcar.service;

import com.racingcar.model.RacingCar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingCarRuleTest {

    @DisplayName("자동차 경주에서 이동하는 규칙 중 4이상이 나오면 상태가 1 증가하는지 테스트")
    @ParameterizedTest
    @MethodSource("provideRacingStatusValue")
    void defaultRacingCarRuleTest(final Integer racingStatusValue, final Integer expected) {

        TestDefaultRacingCarRule rule = new TestDefaultRacingCarRule(racingStatusValue);
        RacingCar racingCar = new RacingCar(1);

        rule.moveRacingCar(racingCar);

        assertEquals(racingCar.getRacingStatus(), expected);
    }

    private static Stream<Arguments> provideRacingStatusValue() {
        return Stream.of(
                Arguments.of(3, 1),
                Arguments.of(5, 2),
                Arguments.of(4, 2)
        );
    }

    @DisplayName("랜덤 값이 0 - 9 사이로 나오는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = 10)
    void generateRandomRacingStatusValueTest(final Integer count) {

        DefaultRacingCarRule rule = new DefaultRacingCarRule();

        IntStream.range(0, count).forEach(i -> {
            Integer statusValue = rule.generateRandomRacingStatusValue();
            assertTrue(0 <= statusValue && statusValue < 10);
        });
    }

    private static class TestDefaultRacingCarRule extends DefaultRacingCarRule {

        private Integer racingStatus;

        TestDefaultRacingCarRule(Integer racingStatus) {
            this.racingStatus = racingStatus;
        }

        @Override
        protected Integer generateRandomRacingStatusValue() {
            return this.racingStatus;
        }
    }
}
