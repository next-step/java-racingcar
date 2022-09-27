package carracing.step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        List<String> carNames = List.of("a", "b", "c");
        cars = new Cars(carNames, () -> 9);
    }

    @Test
    @DisplayName("전체 자동차를 움직일 경우, carTrace가 1, 1, 1 발생")
    void moveAllCars() {
        cars.moveAllCars();
        assertThat(cars.getAllCars())
                .extracting("moveCount", int.class)
                .containsExactly(1, 1, 1);
    }

    @Test
    @DisplayName("전체 자동차가 똑같이 움직인 경우, winner가 a, b, c 발생")
    void getWinner() {
        cars.moveAllCars();
        assertThat(cars.getWinner()).containsExactly("a", "b", "c");
    }

}