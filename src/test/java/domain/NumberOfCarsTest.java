package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfCarsTest {
    static final int DEFAULT_VALUE = 3;
    static final int LOWER_THAN_MIN_VALUE = -1;
    NumberOfCars defaultNumberOfCars;

    @BeforeEach
    void setUp() {
        defaultNumberOfCars = new NumberOfCars(DEFAULT_VALUE);
    }

    @Test
    @DisplayName("NumberOfCars value 가져오기 테스트")
    void getValue() {
        assertEquals(DEFAULT_VALUE, defaultNumberOfCars.getValue());
    }

    @Test
    @DisplayName("유효하지 않은 입력에 대한 constructor 테스트")
    void LowerThanMinValueConstructor() {
        Throwable exception = assertThrows(RuntimeException.class, () -> new NumberOfCars(LOWER_THAN_MIN_VALUE));
        assertEquals("NumberOfCars can not be negative", exception.getMessage());
    }

    @Test
    @DisplayName("constructor 테스트")
    void constructor() {
        assertDoesNotThrow(() -> new NumberOfCars(DEFAULT_VALUE));
    }
}
