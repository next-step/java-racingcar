package race.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    @DisplayName("모든 차가 정상적으로 이동했는지 확인")
    void playMoveStrategyAllCars() {
        String[] carNames = {"aaa", "bbb", "ccc"};

        Cars cars = new Cars(carNames);
        MoveStrategy moveStrategy = () -> true;
        RacingGame racingGame = new RacingGame(cars, moveStrategy);

        racingGame.play();

        for(Car car : cars.cars()){
            assertThat(car.position()).isEqualTo(1);
        }
    }
}