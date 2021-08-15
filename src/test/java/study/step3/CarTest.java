package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.Car;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    Car car = new Car(4);

    @DisplayName("4 이상의 랜덤 값을 받은 경우, 1회 전진")
    @ParameterizedTest
    @CsvSource({
            "4, -",
            "9, -",
    })
    void moveTest_4이상의_랜덤값(int randomNumber, String distance) {
        car.move(randomNumber);
        assertEquals(distance, car.getDistance());
    }

    @DisplayName("4 미만의 랜덤 값을 받은 경우, 0회 전진")
    @Test
    void moveTest_4미만의_랜덤값() {
        car.move(0);
        assertEquals("", car.getDistance());
    }

    @DisplayName("4 이상의 랜덤 값을 2회 받아 2회 전진")
    @Test
    void moveTest_2회_전진() {
        car.move(4);
        car.move(9);

        assertEquals("--", car.getDistance());
    }

    @DisplayName("4 이상의 랜덤 값을 1회 받아 1회 전진")
    @Test
    void moveTest_1회_전진() {
        car.move(5);
        car.move(1);
        car.move(2);
        assertEquals("-", car.getDistance());
    }

}
