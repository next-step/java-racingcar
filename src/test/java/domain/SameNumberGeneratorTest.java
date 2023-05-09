package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SameNumberGeneratorTest {
    int value = 3;
    NumberGenerator sameNumberGenerator;

    @BeforeEach
    void setUp() {
        sameNumberGenerator = new SameNumberGenerator(value);
    }

    @Test
    @DisplayName("생성테스트")
    void create() {
        assertDoesNotThrow(() -> new SameNumberGenerator(value));
    }

    @Test
    @DisplayName("입력받은 값을 그대로 출력한다")
    void generate() {
        assertEquals(value, sameNumberGenerator.generate());
    }
}
