package study.step5;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import study.step5.model.Movement;

/**
 * Movemnet Class Test
 */
public class MovementTest {
    private Movement movement;

    @BeforeEach
    void init(){
        movement = new Movement();
    }

    @DisplayName("랜덤 반환값 0 또는 1 값 테스트")
    @RepeatedTest(value=10)
    void move() {
        assertThat(movement.stopAndMove()).isBetween(0, 1);
    }
}

