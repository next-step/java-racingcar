package domain;

import movingStrategy.AlwaysMove;
import movingStrategy.Moveable;
import movingStrategy.RandomlyMove;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class RacingGameTest {

    private final Moveable alwaysMove = new AlwaysMove();
    private static final int NUMBER_OF_TRIAL = 5;
    private static final int NUMBER_OF_CAR = 3;

    @DisplayName("자동차의 수 또는 시도 횟수가 0보다 작은 경우 IllegalArgumentException 발생")
    @ParameterizedTest
    @CsvSource(value = {"0, 1", "1, 0", "0, 0", "-1, 1", "1, -1", "-1, -1"})
    void test(Integer numberOfCar, Integer numberOfRacing) {
        // When & Then
        Assertions.assertThatThrownBy(() -> {
            new RacingGame(numberOfCar, numberOfRacing, alwaysMove);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차의 수 또는 시도 횟수가 0보다 큰 경우 예외 발생하지 않음")
    @Test
    void gameStartTest() {
        // Given
        int validNumberOfTrial = 5;
        int validNumberOfCar = 3;

        // When
        RacingGame racingGame = new RacingGame(validNumberOfCar, validNumberOfTrial, alwaysMove);

        // Then
        Assertions.assertThatNoException().isThrownBy(racingGame::gameStart);
    }

    @DisplayName("numberOfCar 만큼 자동차가 생성됨")
    @Test
    void carProduceTest() {
        RacingGameResult racingGameResult = playTestGame(alwaysMove);
        List<RacingCar> racingCars = racingGameResult.getRacedCars();
        Assertions.assertThat(racingCars).hasSize(NUMBER_OF_CAR);
    }

    @DisplayName("numberOfTrial 만큼 자동차가 진행함")
    @Test
    void alwaysMoveTest() {
        RacingGameResult racingGameResult = playTestGame(alwaysMove);
        List<RacingCar> racingCars = racingGameResult.getRacedCars();

        Assertions.assertThat(racingCars)
                .allMatch(car -> car.whereIsCar() == NUMBER_OF_TRIAL);
    }

    @DisplayName("0에서 numberOfTrial 사이의 값만큼 자동차가 진행함")
    @Test
    void randomlyMoveTest() {
        RandomlyMove randomlyMove = new RandomlyMove(10, 4);
        RacingGameResult racingGameResult = playTestGame(randomlyMove);
        List<RacingCar> racingCars = racingGameResult.getRacedCars();

        Assertions.assertThat(racingCars)
                .allMatch(car -> car.whereIsCar() <= NUMBER_OF_TRIAL || car.whereIsCar() >= 0);
    }

    private RacingGameResult playTestGame(Moveable moveable) {
        RacingGame racingGame = new RacingGame(RacingGameTest.NUMBER_OF_CAR, RacingGameTest.NUMBER_OF_TRIAL, moveable);
        return racingGame.gameStart();
    }
}