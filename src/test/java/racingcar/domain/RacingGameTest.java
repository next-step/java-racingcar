package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    @Test
    @DisplayName("라운드 실행")
    void 라운드실행() {
        Car[] cars = CarFactory.createCars("bmw,benz,tesla");

        RandomNumber randomNumber = new RandomNumber() {
            private int number = 3;

            @Override
            public int getInt() {
                return number++;
            }
        };

        RacingGame racingGame = new RacingGame(cars, randomNumber);

        racingGame.runSingleRound();

        Assertions.assertThat(cars[0].getDistance()).isEqualTo(0);
        Assertions.assertThat(cars[1].getDistance()).isEqualTo(1);
        Assertions.assertThat(cars[2].getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("우승자조회")
    void 우승자조회() {
        Car[] cars = CarFactory.createCars("bmw,benz,tesla");

        // 우승자는 benz,hyundai
        cars[0].moveForwardOrStop(4);
        cars[1].moveForwardOrStop(4);
        cars[1].moveForwardOrStop(4);
        cars[2].moveForwardOrStop(4);
        cars[2].moveForwardOrStop(4);

        RandomNumber randomNumber = new RandomNumberImpl();
        RacingGame racingGame = new RacingGame(cars, randomNumber);

        Assertions.assertThat(racingGame.getWinners()).contains(new String[]{"benz", "tesla"});
    }
}

