package study.racingcar.car.moving;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarMovingStrategyTest {

    @Test
    @DisplayName("이동 성공 무빙 시드")
    void test_success_movingSeed() {
        // Given
        DefaultMovingSuccessStrategy instance = DefaultMovingSuccessStrategy.getInstance();

        // When
        MovingSeed movingSeed = instance.getMovingSeed();

        // Then
        assertTrue(movingSeed.isMovable());
    }

    @Test
    @DisplayName("이동 실패 무빙 시드")
    void test_fail_movingSeed() {
        // Given
        DefaultMovingFailStrategy instance = DefaultMovingFailStrategy.getInstance();

        // When
        MovingSeed movingSeed = instance.getMovingSeed();

        // Then
        assertFalse(movingSeed.isMovable());
    }

}