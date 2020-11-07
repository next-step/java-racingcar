package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"3:3", "6:6", "100:100", "10:10"}, delimiter = ':')
    @DisplayName("move() 메소드를 사용하여 자동차 이동 최종 이동거리 확인")
    public void 자동차_이동거리_확인(int num1, int num2) {
        Car car = new Car("test");
        for(int i = 0; i < num1; i++) {
            car.move();
        }
        assertEquals(car.getDistance(), num2);
    }

}
