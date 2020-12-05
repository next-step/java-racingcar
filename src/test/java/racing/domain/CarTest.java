package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.Car;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    @DisplayName("전진/멈춤")
    @ParameterizedTest
    @CsvSource(value = {"3,0", "4,1"})
    void move(int power, int expected) {
        //given
        Car car = new Car();

        //when
        car.move(power);

        //then
        assertEquals(expected, car.getPosition());
    }
}
