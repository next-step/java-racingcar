package com.jaenyeong.mission2.racingcar.domain;

import com.jaenyeong.mission2.racingcar.common.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("0부터 9까지 랜덤 값을 반환하는 MoveStrategy 인터페이스의 정적 메서드 테스트")
class MoveStrategyTest extends BaseTest {

    @ParameterizedTest
    @MethodSource("randomIntValues")
    @DisplayName("Distance 클래스 초기화 선언시 최초 이동 거리는 항상 0임을 확인하는 테스트")
    void checkInitDistValueEqualsZeroWhenAlwaysInitDistanceClass(final int randomValue) {
        for (int i = 0; i < randomValue; i++) {
            assertThat(MoveStrategy.moveForRandom()).isBetween(0, 9);
        }
    }
}
