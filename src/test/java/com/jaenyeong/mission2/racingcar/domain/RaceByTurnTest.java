package com.jaenyeong.mission2.racingcar.domain;

import com.jaenyeong.mission2.racingcar.common.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("턴에 따른 경주 데이터 RaceByTurn 클래스 테스트")
class RaceByTurnTest extends BaseTest {

    @ParameterizedTest
    @MethodSource("randomRaceByTurnValues")
    @DisplayName("RaceByTurn 클래스 초기화 선언시 turn, distance 데이터가 파라미터와 일치하는지 테스트")
    void checkRaceByTurn(final int randomTurn, final int randomDist) {
        final RaceByTurn race = new RaceByTurn(randomTurn, randomDist);

        assertEquals(randomTurn, race.getTurn());
        assertEquals(randomDist, race.getDistance());
    }

    private static Stream<Arguments> randomRaceByTurnValues() {
        return Stream.of(
            Arguments.of(getRandomValue(), getRandomValue()),
            Arguments.of(getRandomValue(), getRandomValue()),
            Arguments.of(getRandomValue(), getRandomValue()),
            Arguments.of(getRandomValue(), getRandomValue())
        );
    }
}
