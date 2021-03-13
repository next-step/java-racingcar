package step4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("car 생성자 테스트 - 4자 이하")
    @Test
    void carTest() {
        Car car = new Car("aaaa");
        Assertions.assertEquals(car.getName(), "aaaa");
    }

    @DisplayName("car 생성자 테스트 - 5자 이상")
    @Test
    void carNameSizeOverTest() {
        Assertions.assertThrows(
                IllegalArgumentException.class, () -> new Car("aaaaa"));
    }

    @DisplayName("car 이동 테스트 - 이동했을 경우")
    @Test
    void carMoveTest() {
        Car car = new Car("aaaa");
        car.move(4);
        Assertions.assertEquals(car.getPosition(), 2);
    }

    @DisplayName("car 이동 테스트 - 멈췄을경우")
    @Test
    void catStopTest() {
        Car car = new Car("aaaa");
        car.move(3);
        Assertions.assertEquals(car.getPosition(), 1);
    }


}