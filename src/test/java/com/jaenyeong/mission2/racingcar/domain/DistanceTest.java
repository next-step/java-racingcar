package com.jaenyeong.mission2.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Car 클래스의 이동, 이동한 거리를 담당하는 Distance 클래스 테스트")
class DistanceTest {

    @ParameterizedTest
    @MethodSource("randomIntValues")
    @DisplayName("Distance 클래스 초기화 선언시 최초 이동 거리는 항상 0임을 확인하는 테스트")
    void checkInitDistValueEqualsZeroWhenAlwaysInitDistanceClass(final int randomValue) {
        for (int i = 0; i < randomValue; i++) {
            final Distance distance = new Distance();

            final int expectedValue = 0;

            assertEquals(distance.getDist(), expectedValue);
        }
    }

    @ParameterizedTest
    @MethodSource("randomIntValues")
    @DisplayName("Distance 클래스 초기화 선언시 최초 이동 거리는 항상 음수, 1이상이 아님을 확인하는 테스트")
    void checkInitDistValueEqualsNotNegativeAndGreaterThanOneWhenAlwaysInitDistanceClass(final int randomValue) {
        for (int i = 0; i < randomValue; i++) {
            final Distance distance = new Distance();

            final int negative = -1;
            final int aNumberGreaterThanOne = 1;

            assertThat(distance.getDist()).isNotEqualTo(negative);
            assertThat(distance.getDist()).isNotEqualTo(aNumberGreaterThanOne);
        }
    }

    private static Stream<Arguments> randomIntValues() {
        return Stream.of(
            Arguments.of(getRandomValue()),
            Arguments.of(getRandomValue()),
            Arguments.of(getRandomValue()),
            Arguments.of(getRandomValue())
        );
    }

    private static int getRandomValue() {
        return ThreadLocalRandom.current()
            .nextInt(1, 20);
    }

    @ParameterizedTest
    @MethodSource("randomIntValues")
    @DisplayName("이동시 직전 위치와 동일한 값 또는 직전 위치 + 1 값인지 확인하는 테스트")
    void checkDistanceWhenMove(final int randomValue) {
        for (int i = 0; i < randomValue; i++) {
            Distance distance = new Distance();
            final int currentDist = distance.getDist();

            distance = distance.move();

            assertThat(distance.getDist()).isIn(currentDist, (currentDist + 1));
        }
    }

    @ParameterizedTest
    @MethodSource("randomIntValues")
    @DisplayName("여러번 이동시 이동 후에 위치값은 0부터 이동 횟수 사이의 값인지 확인하는 테스트")
    void checkDistanceWhenMoveSeveralTimes(final int randomValue) {
        Distance distance = new Distance();

        for (int i = 0; i < randomValue; i++) {
            distance = distance.move();
        }

        assertThat(distance.getDist()).isBetween(0, randomValue);
    }
}
