package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarsTest {
    @DisplayName("자동차 N대 생성")
    @Test
    void create() {
        //given
        int carCount = 3;

        //when
        Cars actual = new Cars(carCount, new FixedPowerGenerator());

        //then
        Cars expected = new Cars(Arrays.asList(new Car(), new Car(), new Car()), new FixedPowerGenerator());
        assertEquals(expected, actual);
    }

    @DisplayName("자동차 N대 전진/멈춤")
    @Test
    void move() {
        //given
        List<Car> carList = Arrays.asList(new Car(1), new Car(4));
        Cars cars = new Cars(carList, new FixedPowerGenerator());

        //when
        cars.move();

        //then
        List<Car> expectedCarList = Arrays.asList(new Car(2), new Car(5));
        Cars expected = new Cars(expectedCarList, new FixedPowerGenerator());
        assertEquals(expected, cars);
    }
}
