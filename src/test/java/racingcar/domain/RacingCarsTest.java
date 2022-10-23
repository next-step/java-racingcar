package racingcar.domain;

import exception.CustomException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RacingCars;
import racingcar.exception.CarErrorCode;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {
    @Test
    @DisplayName("자동차 생성 테스트")
    void racingCars_create() {
        RacingCars racingCars = RacingCars.create("test1,test2,test3");
        assertThat(racingCars).isEqualTo(
                RacingCars.create("test1,test2,test3"));
    }

    @Test
    @DisplayName("참여하는 자동차가 하나도 없는 경우 테스트가 실패한다.")
    void racingCars_create_fail() {
         Assertions.assertThatThrownBy(() -> RacingCars.create(""))
                .isInstanceOf(CustomException.class)
                .hasMessage(CarErrorCode.CAR_NAME_NOT_BLANK.getMessage());
    }

    @Test
    @DisplayName("움직이기 위한 최소값보다 낮은 수가 생성되면 움직이지 않는다")
    void racingCars_not_moving_lower_then_minimum_value() {
        RacingCars racingCars = RacingCars.create("test1,test2,test3");
        racingCars.moving(() -> 3);
        List<Car> result = racingCars.copy();
        assertThat(result).extracting("location")
                .containsOnly(0);
    }

    @Test
    @DisplayName("가장 멀리 간 자동차가 우승한다")
    void racingCars_winners() {
        final int winnerValue = 3;
        RacingCars racingCars = RacingCars.create("test1,test2,test3");
        for (int i = 0; i < winnerValue; i++) {
            racingCars.moving(() -> 5);
        }
        List<Car> winners = racingCars.getWinners();
        assertThat(winners).extracting("location")
                .containsOnly(winnerValue);
    }
}
