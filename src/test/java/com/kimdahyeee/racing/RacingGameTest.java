package com.kimdahyeee.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@DisplayName("RacingGame 단위 테스트")
class RacingGameTest {

    @ParameterizedTest
    @DisplayName("자동차는 랜덤 값이 4 미만이면 전진하지 않는다.")
    @ValueSource(ints = {1, 3})
    void stop(int randomValue) {
        RacingGame racingGame = spy(RacingGame.class);
        when(racingGame.getRandomNumber()).thenReturn(randomValue);

        int carPosition = 0;
        int result = racingGame.moveOrStop(carPosition);

        assertEquals(carPosition, result);
    }

    @ParameterizedTest
    @DisplayName("자동차는 랜덤 값이 4 이상이면 전진한다.")
    @ValueSource(ints = {4, 5, 9})
    void move(int randomValue) {
        RacingGame racingGame = spy(RacingGame.class);
        when(racingGame.getRandomNumber()).thenReturn(randomValue);

        int carPosition = 0;
        int result = racingGame.moveOrStop(carPosition);

        assertEquals(++carPosition, result);
    }

    @ParameterizedTest
    @DisplayName("자동차 경주 단위 테스트")
    @MethodSource("carPositionListProvider")
    void racingGame(List<Integer> carPositions, Integer randomNumber, List<Integer> expectedPositions) {
        RacingGame racingGame = spy(new RacingGame());
        when(racingGame.getRandomNumber()).thenReturn(randomNumber);

        List<Integer> newCarPositions = racingGame.move(carPositions);
        assertEquals(expectedPositions, newCarPositions);
    }

    static Stream<Arguments> carPositionListProvider() {
        return Stream.of(
                arguments(Arrays.asList(1, 3, 6), 9, Arrays.asList(2, 4, 7)),
                arguments(Arrays.asList(2, 3, 4), 0, Arrays.asList(2, 3, 4)));
    }
}