package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.RacingGame;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    @DisplayName("3대의 차, 5번 시도 횟수를 입력으로 받으면, 3대의 차, last round가 5인 게임이 만들어진다")
    void testRacingGame_given_3_cars_5_rounds() {
        // Given
        List<Car> cars = Arrays.asList(new Car("test1"), new Car("test2"), new Car("test3"));
        int lastRound = 5;

        // When
        RacingGame racingGame = new RacingGame(cars, lastRound);

        // Then
        assertThat(racingGame.getCars().size()).isEqualTo(cars.size());
        assertThat(racingGame.getLastRound()).isEqualTo(lastRound);
    }

    @Test
    @DisplayName("가장 멀리간 자동차가 우승한다")
    void testFindWinnerOne() {
        // Given
        Car test1 = new Car("test1");
        Car test2 = new Car("test2");
        Car test3 = new Car("test3");
        List<Car> cars = Arrays.asList(test1, test2, test3);
        int lastRound = 5;
        RacingGame racingGame = new RacingGame(cars, lastRound);
        test1.run(() -> true);

        // When
        List<Car> winners = racingGame.findWinner();

        // Then
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners).containsOnly(test1);
    }

    @Test
    @DisplayName("가장 멀리간 자동차가 여러대일 수 있다")
    void testFindWinners() {
        // Given
        Car test1 = new Car("test1");
        Car test2 = new Car("test2");
        Car test3 = new Car("test3");
        List<Car> cars = Arrays.asList(test1, test2, test3);
        int lastRound = 5;
        RacingGame racingGame = new RacingGame(cars, lastRound);
        test1.run(() -> true);
        test2.run(() -> true);

        // When
        List<Car> winners = racingGame.findWinner();

        // Then
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners).containsOnly(test1, test2);
    }
}