package racingcar.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Position;
import racingcar.domain.CarName;
import racingcar.domain.Cars;
import racingcar.strategy.impl.RandomBoundMovingStrategy;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTests {
    @DisplayName("경주에서 우승자를 정해줬을때 결과대로 우승자가 나오는지 테스트")
    @Test
    void findWinnerTest() {

        Car car1 = new Car(new CarName("pobi"), new Position(5));
        Car car2 = new Car(new CarName("crong"), new Position(3));
        Car car3 = new Car(new CarName("honux"), new Position(5));

        Cars cars = Cars.of(Arrays.asList(car1, car2, car3));

        RacingGame racingGame = new RacingGame(cars);

        assertThat(racingGame.findWinners()).contains(new CarName("pobi"), new CarName("honux"));
    }

    @DisplayName("경주에서 게임이 끝났는지 테스트")
    @Test
    void endGameTest() {

        Car car1 = new Car(new CarName("pobi"), new Position(5));
        Car car2 = new Car(new CarName("crong"), new Position(3));
        Car car3 = new Car(new CarName("honux"), new Position(5));

        Cars cars = Cars.of(Arrays.asList(car1, car2, car3));

        RacingGame racingGame = new RacingGame(cars, 1);
        assertThat(racingGame.isEnd()).isEqualTo(false);

        racingGame.race(new RandomBoundMovingStrategy());
        assertThat(racingGame.isEnd()).isEqualTo(true);
    }





}
