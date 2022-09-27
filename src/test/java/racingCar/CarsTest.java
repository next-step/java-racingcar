package racingCar;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    Cars cars = new Cars(new ArrayList<>());

    @Test
    void init_테스트() {
        Cars cars = new Cars(5);
        assertThat(cars.getCars()).hasSize(5);
    }

    @Test
    void 자동차_이름_입력_테스트() {
        String names = "pobi,crong,honux";
        cars.createCars(names);
        assertThat(cars.getCars()).hasSize(3);
        assertThat(cars.getCars().get(0).getName()).isEqualTo("pobi");
        assertThat(cars.getCars().get(1).getName()).isEqualTo("crong");
        assertThat(cars.getCars().get(2).getName()).isEqualTo("honux");
    }

}