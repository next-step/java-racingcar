package racingcar.domain;

import java.util.List;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.domain.movingcondition.MovingCondition;

class RacingGameTest {

    @ParameterizedTest(name = "라운드를 진행했을 때 게임 종료 여부 체크: {4}")
    @MethodSource("provideRacingGameInput")
    void isGameEnded(List<Car> cars, MovingCondition condition, boolean isCarMovable, int playCount, String testDescription) {
        RacingGame racingGame = new RacingGame(cars, condition, playCount);

        for (int i = 0; i < playCount - 1; ++i) {
            racingGame.play();
        }
        Assertions.assertThat(racingGame.isGameEnd()).isFalse();

        racingGame.play();
        Assertions.assertThat(racingGame.isGameEnd()).isTrue();
    }

    @ParameterizedTest(name = "레이싱 게임을 진행했을 때 주어진 조건에 따라 움직였는지 테스트: {4}")
    @MethodSource("provideRacingGameInput")
    void play(List<Car> cars, MovingCondition condition, boolean isCarMovable, int playCount, String testDescription) {
        RacingGame racingGame = new RacingGame(cars, condition, playCount);

        for (int round = 1; round <= playCount; ++round) {
            RoundResult roundResult = racingGame.play();
            List<Integer> expectedResult = getExpectedResult(isCarMovable, round);
            Assertions.assertThat(roundResult.getPositions()).isEqualTo(expectedResult);
        }
    }

    @ParameterizedTest(name = "게임 종료 이후에도 레이스 진행 시도 시 예외 반환: {4}")
    @MethodSource("provideRacingGameInput")
    void playAfterRacingEnd(List<Car> cars, MovingCondition condition, boolean isCarMovable, int playCount, String testDescription) {
        RacingGame racingGame = new RacingGame(cars, condition, playCount);

        Assertions.assertThatThrownBy(() -> {
            for (int round = 1; round <= playCount + 1; ++round) {
                racingGame.play();
            };
        }).isInstanceOf(RuntimeException.class);
    }


    private List<Integer> getExpectedResult(boolean isCarMovable, int playRounds) {
        return isCarMovable ? List.of(playRounds) : List.of(0);
    }

    private static Stream<Arguments> provideRacingGameInput() {
        return Stream.of(
            Arguments.of(List.of(Car.createInitialOne()), (MovingCondition)() -> true, true, 3, "차가 움직일 수 있을 때"),
            Arguments.of(List.of(Car.createInitialOne()), (MovingCondition)() -> false, false, 3, "차가 움직일 수 없을 때")
        );
    }
}
