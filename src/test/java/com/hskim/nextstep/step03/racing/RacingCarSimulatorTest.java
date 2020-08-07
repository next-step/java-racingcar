package com.hskim.nextstep.step03.racing;

import com.hskim.nextstep.step02.utils.StringUtils;
import com.hskim.nextstep.step03.exception.ExceptionMessage;
import com.hskim.nextstep.step03.model.RacingCar;
import com.hskim.nextstep.step03.model.RandomMovableStrategy;
import com.hskim.nextstep.step03.utils.ValidationUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/*
    com.hskim.nextstep.step03 - RacingCarSimulator class 테스트
 */
public class RacingCarSimulatorTest {

    private static RandomMovableStrategy randomMovableStrategy;

    @BeforeAll
    static void setUp() {

        randomMovableStrategy = mock(RandomMovableStrategy.class);
    }

    /*
        모두 항상 이동한다고 가정하여 테스트
     */
    @DisplayName("findWinners() 메소드 검증")
    @Test
    void findWinnersTest() {

        // given
        RacingCarSimulator racingCarSimulator = new RacingCarSimulator(
                Arrays.asList("winner1", "winner2", "winner3", "winner4"),
                5, randomMovableStrategy);
        racingCarSimulator.simulate();

        // when
        when(randomMovableStrategy.isMovable()).thenReturn(true);
        List<String> winnerNameList = racingCarSimulator.findWinners().stream()
                .map(RacingCar::getCarName)
                .collect(Collectors.toList());

        // then
        assertThat(winnerNameList).isEqualTo(Arrays.asList("winner1", "winner2", "winner2", "winner4"));
    }
}
