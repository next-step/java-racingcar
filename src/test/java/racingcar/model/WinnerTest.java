package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Cars;
import racingcar.domain.Winner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {
    private Winner winner;
    private Cars cars;
    private final String WIN_COMMENT = "가 최종 우승했습니다.";

    @BeforeEach
    void setUp() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(new CarName("pobi"), 3));
        carList.add(new Car(new CarName("crong"), 2));
        carList.add(new Car(new CarName("honux"), 2));
        cars = new Cars(carList);

        winner = new Winner(cars);
    }

    @DisplayName("pobi가 우승자로 들어온다.")
    @Test
    void getWinner() {
        assertThat(winner.getWinner()).isEqualTo("pobi" + WIN_COMMENT);
    }
}