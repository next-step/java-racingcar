package racing.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.Cars;
import racing.model.RacingCar;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    List<RacingCar> carList;
    Cars cars;

    @BeforeEach
    void init() {
        carList = List.of(
                new RacingCar(3, "pobi"),
                new RacingCar(2, "crong"),
                new RacingCar(3, "honux")
        );
        cars = new Cars(carList);
    }

    @Test
    @DisplayName("가장 전진 횟수가 많은 차의 전진 횟수를 정상 리턴")
    void test1() throws Exception {
        assertThat(cars.getTopSpeed()).isEqualTo(3);
    }

    @Test
    @DisplayName("우승자의 이름을 정상 리턴한다.")
    void test2() throws Exception {
        assertThat(cars.getWinnerNames()).contains("pobi", "honux");
    }
}