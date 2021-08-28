package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.Car;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    String name = "TEST";
    Car car = new Car(name);

    @DisplayName("이름 getter 테스트")
    @Test
    void getNameTest() {
        assertEquals(name, car.getName());
    }

    @DisplayName("4 이상의 랜덤 값을 받은 경우, 1회 전진")
    @ParameterizedTest
    @CsvSource({
            "4, 1",
            "9, 1",
    })
    void moveTest_4이상의_랜덤값(int randomNumber, int distance) {
        car.move(randomNumber);
        assertEquals(distance, car.getDistance());
    }

    @DisplayName("4 미만의 랜덤 값을 받은 경우, 0회 전진")
    @Test
    void moveTest_4미만의_랜덤값() {
        car.move(0);
        assertEquals(0, car.getDistance());
    }

    @DisplayName("4 이상의 랜덤 값을 2회 받아 2회 전진")
    @Test
    void moveTest_2회_전진() {
        car.move(4);
        car.move(9);

        assertEquals(2, car.getDistance());
    }

    @DisplayName("4 이상의 랜덤 값을 1회 받아 1회 전진")
    @Test
    void moveTest_1회_전진() {
        car.move(5);
        car.move(1);
        car.move(2);
        assertEquals(1, car.getDistance());
    }

}
