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
        String names = "a,b,c";

        //when
        Cars actual = new Cars(names, new FixedPowerGenerator());

        //then
        assertEquals(names.split(",").length, actual.size());
    }

    @DisplayName("자동차 N대 전진/멈춤")
    @Test
    void move() {
        //given
        CarName a = new CarName("a");
        CarName b = new CarName("b");
        List<Car> carList = Arrays.asList(new Car(a, 1), new Car(b, 4));
        Cars cars = new Cars(carList, new FixedPowerGenerator());

        //when
        cars.move();

        //then
        List<Car> expectedCarList = Arrays.asList(new Car(a, 2), new Car(b, 5));
        Cars expected = new Cars(expectedCarList, new FixedPowerGenerator());
        assertEquals(expected, cars);
    }
}
