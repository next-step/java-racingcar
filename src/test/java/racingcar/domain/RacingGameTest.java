package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.domain.movingcondition.MovingCondition;

class RacingGameTest {

    @ParameterizedTest(name = "레이싱 게임을 진행했을 때 주어진 조건에 따라 움직였는지 테스트: {4}")
    @MethodSource("provideRacingGameInput")
    void play(List<Car> cars, MovingCondition condition, boolean isCarMovable, int playCount, String testDescription) {
        RacingGame racingGame = new RacingGame(cars, condition, playCount);

        int playRounds = 0;

        while (!racingGame.isGameEnd()) {
            playRounds++;
            List<Integer> roundResult = racingGame.play();
            List<Integer> expectedResult = getExpectedResult(isCarMovable, playRounds);
            Assertions.assertThat(roundResult).isEqualTo(expectedResult);
        }

        Assertions.assertThat(playRounds).isEqualTo(playCount);
    }

    private List<Integer> getExpectedResult(boolean isCarMovable, int playRounds) {
        return isCarMovable ? List.of(playRounds) : List.of(0);
    }

    private static Stream<Arguments> provideRacingGameInput() {
        return Stream.of(
            Arguments.of(List.of(new Car()), (MovingCondition)() -> true, true, 3, "차가 움직일 수 있을 때"),
            Arguments.of(List.of(new Car()), (MovingCondition)() -> false, false, 3, "차가 움직일 수 없을 때")
        );
    }
}
