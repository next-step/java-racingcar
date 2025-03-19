package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class RacingGameTest {

    @DisplayName("자동차의 수 또는 시도 횟수가 0보다 작은 경우 IllegalArgumentException 발생")
    @ParameterizedTest
    @CsvSource(value = {"0, 1", "1, 0", "0, 0", "-1, 1", "1, -1", "-1, -1"})
    void test(Integer numberOfCar, Integer numberOfRacing) {
        // When & Then
        Assertions.assertThatThrownBy(() -> {
            new RacingGame(numberOfCar, numberOfRacing);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차의 수 또는 시도 횟수가 0보다 큰 경우 예외 발생하지 않음")
    @Test
    void gameStartTest() {
        // Given
        int numberOfTrial = 5;
        int numberOfCar = 3;

        // When
        RacingGame racingGame = new RacingGame(numberOfCar, numberOfTrial);

        // Then
        Assertions.assertThatNoException().isThrownBy(racingGame::gameStart);
    }

    @DisplayName("numberOfCar 만큼 자동차가 생성됨")
    @Test
    void carProduceTest() {
        // Given
        int numberOfTrial = 5;
        int numberOfCar = 3;

        // When
        RacingGame racingGame = new RacingGame(numberOfCar, numberOfTrial);

        // Then
        RacingGameResult racingGameResult = racingGame.gameStart();
        List<RacingCar> racingCars = racingGameResult.getRacedCars();
        Assertions.assertThat(racingCars).hasSize(numberOfCar);
    }

    @DisplayName("0과 numberOfTrial 사이만큼 자동차가 진행함")
    @Test
    void gameProgressTest() {
        // Given
        int numberOfTrial = 5;
        int numberOfCar = 3;

        // When
        RacingGame racingGame = new RacingGame(numberOfCar, numberOfTrial);

        // Then
        RacingGameResult racingGameResult = racingGame.gameStart();
        List<RacingCar> racingCars = racingGameResult.getRacedCars();

        Assertions.assertThat(racingCars)
                .allMatch(car -> car.whereIsCar() >= 0 && car.whereIsCar() <= numberOfTrial);
    }
}