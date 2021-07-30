package racingcar.step5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.step5.domain.Car;
import racingcar.step5.domain.RandomUtil;
import racingcar.step5.domain.Winner;

import java.util.List;

class WinnerTest {
    String carList[] = {"toby", "ronaldo", "cony"};
    Winner winner;
    List<Car> cars;

    @BeforeEach
    void init() {

        cars = Car.createCars(carList);
        cars.get(0).move(new RandomUtil());
        cars.get(1).move(new RandomUtil());
        cars.get(2).move(new RandomUtil());
        winner = new Winner(cars);

    }

    @Test
    @DisplayName("우승자 출력 테스트")
    void 우승자출력() {
        Assertions.assertThat(winner.getWinnerList().get(0)).isEqualTo(cars.get(0).getName());
    }

}