package com.hskim.nextstep.step03.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/*
    com.hskim.nextstep.step03 - RacingCar class 테스트
 */
public class RacingCarTest {

    private RacingCar racingCar;

    @BeforeEach
    void setUp() {

        racingCar = new RacingCar("test");
    }

    @DisplayName("moveForward() 메소드 이동한 경우 검증")
    @ParameterizedTest
    @ValueSource(ints = {3, 5, 7, 9, 2, 4, 6, 8})
    void moveForwardMovedTest(int distance) {

        // given
        RandomMovableStrategy randomMovableStrategy = mock(RandomMovableStrategy.class);

        // when
        when(randomMovableStrategy.isMovable()).thenReturn(true);

        // then
        assertThat(racingCar.moveForward(distance, randomMovableStrategy)).isEqualTo(distance);
    }

    @DisplayName("moveForward() 메소드 이동 실패 한 경 검증")
    @ParameterizedTest
    @ValueSource(ints = {3, 5, 7, 9, 2, 4, 6, 8})
    void moveForwardStayTest(int distance) {

        // given
        RandomMovableStrategy randomMovableStrategy = mock(RandomMovableStrategy.class);

        // when
        when(randomMovableStrategy.isMovable()).thenReturn(false);

        // then
        assertThat(racingCar.moveForward(distance, randomMovableStrategy)).isEqualTo(0);
    }
}
