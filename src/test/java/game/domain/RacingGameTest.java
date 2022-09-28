package game.domain;

import game.domain.car.Car;
import game.domain.car.RacingGameCar;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class RacingGameTest {

    @DisplayName("자동차 중 위치 값이 가장 높은 자동차를 우승자로 반환한다.")
    @Test
    void winners(){
        RacingGameCar car1 = new RacingGameCar("1");
        car1.forward(4);
        RacingGameCar car2 = new RacingGameCar("2");
        car2.forward(3);
        RacingGameCar car3 = new RacingGameCar("3");
        car3.forward(4);
        RacingGameCarList racingGameCars = new RacingGameCarList(Arrays.asList(car1, car2, car3));
        RacingGame racingGame = new RacingGame(new RacingGameRule(4,10),racingGameCars,5);

        Assertions.assertThat(racingGame.winners(racingGameCars).cars()).containsOnly(car1,car3);
        Assertions.assertThat(racingGame.winners(racingGameCars).cars()).doesNotContain(car2);
    }
}
