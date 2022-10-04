package game.domain;

import game.domain.car.RacingGameCar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class RacingGameCarListTest {

    @DisplayName("만들 자동차의 대수를 입력하면 리스트에 대수만큼 자동차를 추가한다.")
    @Test
    void makeCars() {
        assertThat(RacingGameCarList.makeRacingGameCars(4).cars().size()).isEqualTo(4);
    }

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

        assertAll(
                () -> assertThat(racingGameCars.winners().cars()).containsOnly(car1,car3),
                () -> assertThat(racingGameCars.winners().cars()).doesNotContain(car2)
        );
    }
}
