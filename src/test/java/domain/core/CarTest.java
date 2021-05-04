package domain.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static domain.core.GameOptions.DISTANCE_PRINT;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @Test
    @DisplayName("AccelPower 가 5일 때 전진")
    void move() {
        //given
        Car car = new Car(new CarName(""));
        Accelerator accelPower = new Accelerator(5);

        //when
        car.move(accelPower);

        //then
        assertEquals(DISTANCE_PRINT, car.getDistancePrintMessage());
    }

    @Test
    @DisplayName("AccelPower 가 3일 때 정지")
    void stop() {
        //given
        Car car = new Car(new CarName(""));
        Accelerator accelPower = new Accelerator(3);

        //when
        car.move(accelPower);

        //then
        assertEquals("", car.getDistancePrintMessage());
    }

    @Test
    @DisplayName("자동차 이름 넣고 생성 되는지")
    void constructor_car_name() {
        //given
        String name = "tesla";
        CarName carName = new CarName(name);

        //when
        Car car = new Car(carName);

        //then
        assertEquals(name, car.getName());
    }

    @Test
    @DisplayName("자동차 생성하고 초기 거리 0인지")
    void constructor_distance() {
        //given
        int distance = 0;

        //when
        Car car = new Car(new CarName(""));

        //then
        assertEquals(distance, car.getDistance());
    }
}
