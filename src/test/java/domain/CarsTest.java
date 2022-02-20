package domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        List<String> names = Arrays.asList("박찬우", "박찬종", "아이시스");
        cars = new Cars(names);
    }

    @Test
    void Car_List를_초기화한다() {
        assertThat(cars.getCars().size()).isEqualTo(3);
    }

    @Test
    void index를_통한_Car별_전진_수행() {
        cars.moveCar(0);
        cars.moveCar(0);

        assertThat(cars.getCars().get(0).getDistance()).isEqualTo(2);
    }

    @Test
    void 모든Car_이름_위치_String_변환() {
        cars.moveCar(0);
        cars.moveCar(0);
        cars.moveCar(2);

        assertThat(cars.convertCarsStatus()).isEqualTo("박찬우 : --\n박찬종 : \n아이시스 : -\n");
    }

    @Test
    void 승자계산() {
        cars.moveCar(0);
        cars.moveCar(0);
        cars.moveCar(2);
        cars.moveCar(2);

        assertThat(cars.convertWinner()).isEqualTo("박찬우, 아이시스");
    }
}
