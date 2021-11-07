package step3.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    void 경주_게임을_생성한다() {
        //given
        List<Car> carList = Arrays.asList(Car.create(), Car.create(), Car.create());
        Cars cars = Cars.join(carList);
        RacingGame racingGame = RacingGame.create(3, Participant.join(cars));
        //when & then
        assertThat(racingGame).isNotNull();
    }

    @Test
    void 경주를_시작한다() {
        //given
        List<Car> carList = Arrays.asList(Car.create(), Car.create(), Car.create());
        Cars cars = Cars.join(carList);
        //when
        RacingGame racingGame = RacingGame.create(3, Participant.join(cars));
        //then
        racingGame.start();
    }
}
