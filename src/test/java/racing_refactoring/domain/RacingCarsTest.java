package racing_refactoring.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing_refactoring.util.RacingCarFactory;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class RacingCarsTest {

    @DisplayName("입력받은 자동차 리스트를 생성하는 과정에서 유효성 검사 실패")
    @ParameterizedTest
    @ValueSource(strings = {"car1"})
    void construct_fail(String names) {
        assertThatThrownBy(() -> RacingCarFactory.initRacing(names)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참가하는 자동차는 두 대 이상이어야 합니다.");

    }

    @DisplayName("생성된 자동차 리스트 안에 해당 자동차가 있는지 확인")
    @ParameterizedTest
    @ValueSource(strings = {"car1, car2"})
    void construct(String names) {
        RacingCars racingCars = new RacingCars(RacingCarFactory.initRacing(names));
        assertThat(racingCars.getRacingCars()).contains(new RacingCar("car1"));
        assertThat(racingCars.getRacingCars()).contains(new RacingCar("car2"));
    }

    @DisplayName("우승 자동차 확인")
    @Test
    void findWinners() {
        List<RacingCar> racingCarList = new ArrayList<>();
        racingCarList.add(new RacingCar("car1", 1));
        racingCarList.add(new RacingCar("car2", 2));
        racingCarList.add(new RacingCar("car3", 3));
        RacingCars racingCars = new RacingCars(racingCarList);

        RacingCars winners = RacingCars.findWinners(racingCars);
        assertThat(winners.getRacingCars()).contains(new RacingCar("car3", new RacingPosition(3)));
    }
}