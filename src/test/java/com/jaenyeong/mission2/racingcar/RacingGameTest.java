package com.jaenyeong.mission2.racingcar;

import com.jaenyeong.mission2.racingcar.common.BaseTest;
import com.jaenyeong.mission2.racingcar.domain.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DisplayName("레이싱 게임의 컨트롤러 역할을 하는 RacingGame 클래스 테스트")
class RacingGameTest extends BaseTest {

    @ParameterizedTest
    @MethodSource("randomIntValues")
    @DisplayName("Cars 객체의 수를 전달하여 원하는 수만큼 생성 됐는지 확인하는 테스트")
    void checkExpectedNumberOfCars(final int randomValue) {
        final RacingGame game = new RacingGame();

        final Cars cars = game.getCars(randomValue);

        assertEquals(cars.getHowManyRacingCars(), randomValue);
    }

    @ParameterizedTest
    @MethodSource("randomIntValues")
    @DisplayName("Cars 객체의 수를 전달하여 원하는 수가 아닌 수를 반환하는 경우에 대해 확인하는 테스트")
    void checkIsNotExpectedNumberOfCars(final int randomValue) {
        final RacingGame game = new RacingGame();

        final Cars cars = game.getCars(randomValue);

        assertNotEquals(cars.getHowManyRacingCars(), randomValue + 1);
        assertNotEquals(cars.getHowManyRacingCars(), randomValue - 1);
    }

    @ParameterizedTest
    @MethodSource("randomIntValues")
    @DisplayName("게임 진행 횟수만큼 턴수가 올바르게 증가하는지 확인하는 테스트")
    void checkCurrentTurnByTryTimes(final int randomValue) {
        final RacingGame game = new RacingGame();

        game.racingGivenNumberOfTimes(randomValue, new Cars(randomValue));

        assertEquals(game.getCurrentTurn(), randomValue);
    }

    @ParameterizedTest
    @MethodSource("randomIntValues")
    @DisplayName("모든 Car 객체가 이동한 거리가 0부터 주어진 턴 사이인지 확인하는 테스트")
    void checkRacingOfCarsWhenGivenNumberOfTryTimes(final int randomValue) {
        final RacingGame game = new RacingGame();

        final Cars cars = game.getCars(randomValue);

        game.racingGivenNumberOfTimes(randomValue, cars);

        for (int lastDist : cars.getDistanceRacingCars()) {
            assertThat(lastDist).isBetween(0, randomValue);
        }
    }
}
