package model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarsTest {


    @ParameterizedTest(name = "{0} 개의 차 생성")
    @ValueSource(ints = {1, 3, 5, 9})
    void 생성_객체만큼_추가되는지_확인(int carNumber) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNumber; i++) {
            cars.add(new Car(new Position()));
        }

        assertThat(cars).hasSize(carNumber);
    }

    @Test
    void 차가_0대일_경우() {
        assertThrows(RuntimeException.class, () -> new Cars(new ArrayList<>()));
    }
}
