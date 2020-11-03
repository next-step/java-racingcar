package study.racingcar.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racingcar.car.moving.DefaultMovingSuccessStrategy;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    Car car;

    @BeforeEach
    void init() {
        car = new Car(DefaultMovingSuccessStrategy.getInstance());
    }

    @Test
    @DisplayName("자동차 전진")
    void test_goForward() {

        // When
        car.goForward();

        // Then
        int currentPosition = car.getCurrentPosition();
        assertEquals(currentPosition, 1);
    }

    @Test
    @DisplayName("자동차 정지")
    void test_stop() {
        // When
        car.stop();

        // Then
        int currentPosition = car.getCurrentPosition();
        assertEquals(currentPosition, 0);
    }

}