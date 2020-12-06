package com.jaenyeong.mission2.racingcar.domain;

import com.jaenyeong.mission2.racingcar.common.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
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
}
