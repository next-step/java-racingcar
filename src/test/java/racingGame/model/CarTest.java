package racingGame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {
    
    Car car;
    
    @BeforeEach
    void setUp() {
        car = new Car();
    }
    
    @Test
    void carGenerateTest() {
        assertThat(car);
    }
    
    @Test
    void carGenerateAndInitTest() {
        assertThat(car.findLocation()).isEqualTo(1);
    }

    @Test
    void carForwardTest() {
        int num = 5;
        car.forward(num);
        car.forward(num);
        assertThat(car.forward(num)).isEqualTo(4);
    }
    
    @ParameterizedTest
    @ValueSource(ints = {4, 8})
    void carIsForward(int num) {
        assertThat(car.forward(num)).isEqualTo(2);
    }
    
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3})
    void carIsNotForward(int num) {
        assertThat(car.forward(num)).isEqualTo(1);
    }

}