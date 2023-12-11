package race.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("차 이름이 정상적으로 등록 되는지 확인")
    void createCarNames() {
        String[] carNames = {"aaa", "bbb", "ccc"};
        Cars cars = new Cars(carNames);

        assertThat(cars.cars().size()).isEqualTo(3);
        assertThat(cars.cars().get(0).name()).isEqualTo("aaa");
        assertThat(cars.cars().get(1).name()).isEqualTo("bbb");
        assertThat(cars.cars().get(2).name()).isEqualTo("ccc");
    }
    @Test
    @DisplayName("max position 확인")
    void maxPosition() {
        String[] carNames = {"aaa", "bbb", "ccc"};
        Cars cars = new Cars(carNames);

        cars.cars().get(0).move(() -> true); // position : 1
        cars.cars().get(0).move(() -> true); // position : 2
        cars.cars().get(0).move(() -> true); // position : 3

        cars.cars().get(1).move(() -> true); // position : 1
        cars.cars().get(1).move(() -> true); // position : 2

        cars.cars().get(2).move(() -> true); // position : 1

        assertThat(cars.maxPosition()).isEqualTo(3);
    }

}