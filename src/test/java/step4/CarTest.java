package step4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void test001() {
        Assertions.assertThrows(
                IllegalArgumentException.class, () -> new Car("aaaaa"));
    }

    @Test
    void test002() {
        Assertions.assertDoesNotThrow(() -> new Car("aaaa"));
    }

    @Test
    void test003() {
        Car car = new Car("aaaa");
        car.move(4);
        Assertions.assertEquals(car.getPosition(), 2);
    }

    @Test
    void test004() {
        Car car = new Car("aaaa");
        car.move(3);
        Assertions.assertEquals(car.getPosition(), 1);
    }

    @Test
    void test005() {
        Car car = new Car("aaaa");
        Assertions.assertEquals(car.getName(), "aaaa");
    }


}