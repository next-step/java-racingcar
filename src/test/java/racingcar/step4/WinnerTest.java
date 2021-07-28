package racingcar.step4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class WinnerTest {
    String carList[] = {"toby", "ronaldo", "cony"};
    Winner winner;
    List<Car> cars;

    @BeforeEach
    void init() {

        cars = Car.createCars(carList);
        cars.get(0).move(3);
        cars.get(1).move(9);
        cars.get(2).move(1);
        winner = new Winner(cars);

    }

    @Test
    @DisplayName("우승자 출력 테스트")
    void 우승자출력() {
        winner.getWinnerList();
        Assertions.assertThat(winner.winners.get(0)).isEqualTo(cars.get(0).getName());
    }

}