package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    final static int INITIAL_POSITION = 3;
    final static int MOVE_DEFAULT_VALUE = 2;

    Car defaultCar;

    @BeforeEach
    void setUp() {
        defaultCar = new Car(INITIAL_POSITION);
    }

    @Test
    @DisplayName("Car 생성자가 제대로 생성되는지 확인")
    void constructor() {
        assertDoesNotThrow(() -> new Car(INITIAL_POSITION));
    }

    @Test
    @DisplayName("Car move test")
    void move() {
        defaultCar.move(MOVE_DEFAULT_VALUE);
        assertEquals(INITIAL_POSITION + MOVE_DEFAULT_VALUE, defaultCar.getPosition());
    }

    @Test
    @DisplayName("Car random move test")
    void randomMove() {
        defaultCar.randomMove();
        defaultCar.randomMove();
        assertThat(defaultCar.getPosition()).isBetween(INITIAL_POSITION, INITIAL_POSITION + MOVE_DEFAULT_VALUE);
    }

    @Test
    @DisplayName("Car location test")
    void getLocation() {
        assertEquals(new Car(3).getPosition(), defaultCar.getPosition());
    }

    @Test
    @DisplayName("객체의 주소가 다르지만 값이 같을 경우 equals test")
    void testEquals() {
        assertEquals(new Car(INITIAL_POSITION), defaultCar);
    }

    @Test
    @DisplayName("Car toString test")
    void testToString() {
        assertEquals("{location : 3}", defaultCar.toString());
    }
}
