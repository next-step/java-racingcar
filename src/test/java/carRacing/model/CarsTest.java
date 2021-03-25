package carRacing.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private Cars cars;
    private Car carA;
    private Car carB;
    private Car carC;

    @BeforeEach
    void initializeCarsTest() {
        carA = new Car("carA", 3);
        carB = new Car("carB", 3);
        carC = new Car("carC", 1);

        List<Car> carList = Arrays.asList(carA, carB, carC);
        cars = new Cars(carList);
    }

    @Test
    @DisplayName("get winners test")
    void getWinnersTest() {
        assertThat(cars.getWinners()).isEqualTo(new Cars(Arrays.asList(carA, carB)));
    }

    @Test
    @DisplayName("car list toString display test")
    void toStringTest() {
        System.out.println(cars.toString());
        assertThat(cars.toString()).contains(carA.toString(), carB.toString(), carC.toString());
    }

    @Test
    @DisplayName("get car name list test")
    void getCarNameList() {
        assertThat(cars.getNameList()).isEqualTo(String.join(Cars.DELIMITER, carA.getCarName(), carB.getCarName(), carC.getCarName()));
    }

}