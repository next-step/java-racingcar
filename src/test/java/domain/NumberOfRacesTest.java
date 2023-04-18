package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfRacesTest {
    static final int DEFAULT_VALUE = 3;
    static final int LOWER_THAN_MIN_VALUE = -1;

    NumberOfRaces defaultNumberOfRaces;

    @BeforeEach
    void setUp() {
        defaultNumberOfRaces = new NumberOfRaces(DEFAULT_VALUE);
    }

    @Test
    @DisplayName("NumberOfRaces value 가져오기 테스트")
    void getValue() {
        assertEquals(DEFAULT_VALUE, defaultNumberOfRaces.getValue());
    }

    @Test
    @DisplayName("유효하지 않은 입력에 대한 constructor 테스트")
    void LowerThanMinValueConstructor() {
        Throwable exception = assertThrows(RuntimeException.class, () -> new NumberOfRaces(LOWER_THAN_MIN_VALUE));
        assertEquals("NumberOfRaces can not be negative", exception.getMessage());
    }

    @Test
    @DisplayName("constructor 테스트")
    void constructor() {
        assertDoesNotThrow(() -> {
            new NumberOfRaces(DEFAULT_VALUE);
        });
    }
}
