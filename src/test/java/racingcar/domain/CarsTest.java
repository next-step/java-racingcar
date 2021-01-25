package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("moveAll() 호출 시 모든 Car들이 한 라운드를 진행")
    @Test
    void moveAll() {
        // given
        Cars cars = new Cars(createCarNames());

        // when
        cars.moveAll(new FirstCarForwardMovementCondition());

        // then
        Car car0 = cars.getCars().get(0);
        assertThat(car0.getLocation()).isEqualTo(1);
    }

    @DisplayName("selectWinners() 호출 시 우승자 선정")
    @Test
    void selectWinners() {
        // given
        Cars cars = new Cars(createCarNames());
        playMultipleRounds(cars);

        // when
        List<String> winners = cars.selectWinners();

        // then
        assertThat(winners.get(0)).isEqualTo("car1");
    }

    public List<String> createCarNames() {
        return List.of(
                "car0",
                "car1",
                "car2"
        );
    }

    private void playMultipleRounds(final Cars cars) {
        cars.moveAll(new FirstCarForwardMovementCondition());
        cars.moveAll(new SecondCarForwardMovementCondition());
        cars.moveAll(new SecondCarForwardMovementCondition());
    }
}