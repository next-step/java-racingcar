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
        car.forward();
        car.forward();
        assertThat(car.forward()).isEqualTo(4);
    }
    
    @ParameterizedTest
    @ValueSource(ints = {4, 6, 8})
    void carIsForward(int num) {
        assertThat(car.isForwardByRandom(num)).isTrue();
    }
    
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void carIsNotForward(int num) {
        assertThat(car.isForwardByRandom(num)).isFalse();
    }

}