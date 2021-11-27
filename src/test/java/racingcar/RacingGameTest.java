package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.RacingGame;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    @DisplayName("3대의 차를 입력으로 받으면, 3대의 차를 가진 게임이 만들어진다")
    void testRacingGame_given_3_cars_5_rounds() {
        // Given
        List<Car> givenCars = Arrays.asList(new Car("test1"), new Car("test2"), new Car("test3"));
        Cars cars = new Cars(givenCars);

        // When
        RacingGame racingGame = new RacingGame(cars);

        // Then
        assertThat(racingGame.getCars().getList().size()).isEqualTo(givenCars.size());
    }

    @Test
    @DisplayName("가장 멀리간 자동차가 우승한다")
    void testFindWinnerOne() {
        // Given
        Car test1 = new Car("test1", 2);
        Car test2 = new Car("test2", 1);
        Car test3 = new Car("test3", 1);
        Cars cars = new Cars(Arrays.asList(test1, test2, test3));
        RacingGame racingGame = new RacingGame(cars);

        // When
        List<Car> winners = racingGame.getWinners();

        // Then
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners).containsOnly(test1);
    }

    @Test
    @DisplayName("가장 멀리간 자동차가 여러대일 수 있다")
    void testFindWinners() {
        // Given
        Car test1 = new Car("test1", 2);
        Car test2 = new Car("test2", 2);
        Car test3 = new Car("test3", 1);
        Cars cars = new Cars(Arrays.asList(test1, test2, test3));
        RacingGame racingGame = new RacingGame(cars);

        // When
        List<Car> winners = racingGame.getWinners();

        // Then
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners).containsOnly(test1, test2);
    }
}