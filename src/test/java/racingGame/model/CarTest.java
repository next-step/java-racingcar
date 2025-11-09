package racingGame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {
    
    @Test
    void carGenerateTest() {
        Car car = new Car();
        assertThat(car);
    }
    
    @Test
    void carGenerateAndInitTest() {
        Car car = new Car();
        assertThat(car.findLocation()).isEqualTo(1);
    }

    @Test
    void carMoveTest() {
        Car car = new Car();
        car.move();
        car.move();
        car.move();
        assertThat(car.findLocation()).isEqualTo(4);
    }

}