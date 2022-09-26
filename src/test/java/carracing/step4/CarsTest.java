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
    @DisplayName("moveAllCars 테스트 : 결과 1,1,1")
    void moveAllCars() {
        cars.moveAllCars();
        assertThat(cars.getAllCarsTrace())
                .extracting("moveCnt", int.class)
                .containsExactly(1, 1, 1);
    }

    @Test
    void getWinner() {
        cars.moveAllCars();
        assertThat(cars.getWinner()).containsExactly("a", "b", "c");
    }

}