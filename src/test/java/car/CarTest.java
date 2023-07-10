package car;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import car.model.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @Test
    @DisplayName("equals : 메소드 확인, name와 위치가 같으면 , 두 객체는 같다")
    void 자동차_이름이_같다면_같은_객체() {
        final Car car = new Car("hello");
        final Car newCar = new Car("hello");

        assertEquals(car, newCar);
    }


    @Test
    @DisplayName("isSamePositionTest : position 이 같다면, true 를 반환한다.")
    void 자동차_위치_같은지_확인() {
        final Car car = new Car("hello", 5);
        final Car newCar = new Car("hel2", 5);
        assertTrue(car.isSamePosition(newCar));
    }


    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    @DisplayName("경계, 양 끝단 테스트 : 만약 movable 숫자가 4이상 이면, 자동차는 간다.")
    void 자동자_4이상_일때_움직_가능(int carSpeed) {
        // Given
        final int CAR_MOVE = 1;
        Car car = new Car("hello", 0);

        // When
        car = car.move(carSpeed);
        // Then
        assertTrue(car.isSamePosition(CAR_MOVE));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    @DisplayName("경계, 양 끝단 테스트 : 만약 movable 숫자가 3이하 이면, 자동차는 못 간다.")
    void 자동자_3이하_일때_움직_가능(int carSpeed) {
        final int CAR_STOP = 0;
        Car car = new Car("hello", 0);

        car = car.move(carSpeed);

        assertTrue(car.isSamePosition(CAR_STOP));
    }
}
