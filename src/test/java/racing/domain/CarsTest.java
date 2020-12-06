package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @DisplayName("우승자 찾기")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,1", "1,2,2,2", "5,5,5,3"})
    void getWinners(int p1, int p2, int p3, int expected) {
        //given
        CarName a = new CarName("a");
        CarName b = new CarName("b");
        CarName c = new CarName("c");
        List<Car> carList = Arrays.asList(new Car(a, p1), new Car(b, p2), new Car(c, p3));
        Cars cars = new Cars(carList, new FixedPowerGenerator());

        //when
        List<Car> winners = cars.getWinners();

        //then
        assertEquals(expected, winners.size());
    }
}
