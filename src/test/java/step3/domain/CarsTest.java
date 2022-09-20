package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CarsTest {
    @Test
    @DisplayName("생성 테스트")
    void ctorTest() {
        //given
        List<Car> carList = List.of(
                new Car(),
                new Car(),
                new Car()
        );

        //then
        assertDoesNotThrow(() -> new Cars(carList));
    }

    @Test
    @DisplayName("size체크 테스트")
    void getSizeTest() {
        //given
        List<Car> list = List.of(new Car());

        //when
        Cars cars = new Cars(list);

        //then
        assertThat(cars.size()).isEqualTo(1);

    }

    @Test
    @DisplayName("자동차 추가 테스트")
    void addCarTest() {
        //given
        List<Car> list = List.of(new Car());
        Cars cars = new Cars(list);

        //when
        Cars addCar = cars.addCar(new Car());

        //then
        assertThat(addCar.size()).isEqualTo(2);

    }


}
