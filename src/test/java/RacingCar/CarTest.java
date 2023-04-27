package RacingCar;

import RacingCar.Model.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {

    @Test
    @DisplayName("자동차가 앞으로 잘 이동하는지")
    void moveCarTest() {

        //given
        Car car = new Car(1, "pobi");

        //when
        car.move(6);

        //then
        int expected = 2;
        int acutal = car.getLocation();
        assertEquals(expected, acutal);

    }

    @Test
    @DisplayName("자동차 이름은 5자 초과할때 확인")
    void checkCarNameOver5() {

        //given,when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Car car = new Car(1, "abcdef");
        });

        //then
        String expected = "abcdef의 자동차 이름은 5자 이하여야 합니다.";
        String actual = exception.getMessage();
        assertEquals(expected, actual);

    }
}
