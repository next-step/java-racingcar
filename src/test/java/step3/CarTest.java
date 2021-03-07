package step3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {

    @DisplayName("자동차 이동 테스트")
    @ParameterizedTest
    @CsvSource(value = {"4,4", "5,5"})
    void move(int distance, int exp) {
        Car car = new Car();
        car.move(distance);
        assertEquals(exp, car.getPosition());
    }
}
