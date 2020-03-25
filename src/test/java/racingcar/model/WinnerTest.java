package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.*;

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
        carList.add(new Car(new CarName("pobi"), new Distance(3)));
        carList.add(new Car(new CarName("crong"), new Distance(2)));
        carList.add(new Car(new CarName("honux"), new Distance(2)));
        cars = new Cars(carList);

        winner = new Winner(cars);
    }

    @DisplayName("pobi가 우승자로 들어온다.")
    @Test
    void getWinner() {
        assertThat(winner.getWinner()).isEqualTo("pobi" + WIN_COMMENT);
    }
}