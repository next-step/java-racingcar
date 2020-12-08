package com.jaenyeong.mission2.racingcar.domain;

import com.jaenyeong.mission01.stringcalculator.Operator;
import com.jaenyeong.mission2.racingcar.common.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("도메인 차의 역할을 담당하는 Car 클래스 테스트")
class CarTest extends BaseTest {

    @ParameterizedTest
    @MethodSource("randomIntValues")
    @DisplayName("Car 클래스 초기화 선언시 현재 위치가 0임을 확인하는 테스트")
    void checkInitDistValueEqualsZeroWhenAlwaysInitCarClass(final int randomValue) {
        for (int i = 0; i < randomValue; i++) {
            final Car car = new Car();

            final int expectedValue = 0;

            assertEquals(car.getCurrentDistance(), expectedValue);
        }
    }

    @ParameterizedTest
    @MethodSource("randomIntValues")
    @DisplayName("Car 클래스 초기화 선언시 최초 이동 거리는 항상 음수, 1이상이 아님을 확인하는 테스트")
    void checkInitDistValueEqualsNotNegativeAndGreaterThanOneWhenAlwaysInitCarClass(final int randomValue) {
        for (int i = 0; i < randomValue; i++) {
            final Car car = new Car();

            final int negative = -1;
            final int aNumberGreaterThanOne = 1;

            assertThat(car.getCurrentDistance()).isNotEqualTo(negative);
            assertThat(car.getCurrentDistance()).isNotEqualTo(aNumberGreaterThanOne);
        }
    }

    @ParameterizedTest
    @MethodSource("randomIntValues")
    @DisplayName("여러 번 이동시 이동 후에 위치값은 0부터 이동 횟수 사이의 값인지 확인하는 테스트")
    void checkDistanceWhenMoveSeveralTimes(final int randomValue) {
        final Car car = new Car();

        for (int i = 0; i < randomValue; i++) {
            car.move();
        }

        assertThat(car.getCurrentDistance()).isBetween(0, randomValue);
    }

    @ParameterizedTest
    @MethodSource("randomIntValues")
    @DisplayName("특정 Car 객체가 임의의 횟수만큼 이동 후 거리 기록 유효성 테스트")
    void check(final int randomValue) {
        final Car car = new Car();

        for (int i = 0; i < randomValue; i++) {
            car.move();
        }

        final int start = 0;
        final List<Integer> history = car.getRacingHistory();
        for (final int distance : history) {
            assertThat(distance).isBetween(start, randomValue);
        }
    }

    @ParameterizedTest
    @MethodSource("countAndValidName")
    @DisplayName("Car 클래스 초기화 선언시 이름을 받는 생성자 및 이름 유효성 테스트")
    void checkCarName(final String carName) {
        final Car car = new Car(carName);

        assertEquals(car.getName(), carName);
    }

    private static Stream<Arguments> countAndValidName() {
        return Stream.of(
            Arguments.of("재녕"),
            Arguments.of("King"),
            Arguments.of("Apple"),
            Arguments.of("12345"),
            Arguments.of("1234"),
            Arguments.of("123"),
            Arguments.of("12"),
            Arguments.of("1")
        );
    }

    @ParameterizedTest
    @MethodSource("invalidName")
    @DisplayName("Car 클래스 초기화 선언시 올바르지 않은 이름을 받았을 때 테스트")
    void checkCarNameWhenGivenInvalidName(final String carName) {
        assertThatThrownBy(() -> {
            final Car car = new Car(carName);
            assertEquals(car.getName(), carName);
        })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("invalid name");
    }

    private static Stream<Arguments> invalidName() {
        return Stream.of(
            Arguments.of("Jaenyeong"),
            Arguments.of(""),
            Arguments.of("ABCDEFG"),
            Arguments.of("      "),
            Arguments.of("12367097691238789")
        );
    }
}
