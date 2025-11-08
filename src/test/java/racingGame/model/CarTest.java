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
        Car car = new Car(0);
        assertThat(car.location).isEqualTo(0);
    }
    
    @Test
    void carMoveTest() {
        Car car = new Car(0);
        car.move();
        car.move();
        car.move();
        assertThat(car.location).isEqualTo(3);
    }

}