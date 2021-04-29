import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationUtilsTest {

    @Test
    void isRun() {
        assertTrue(ValidationUtils.isRun(4));
        assertTrue(ValidationUtils.isRun(9));
        assertFalse(ValidationUtils.isRun(3));
        assertFalse(ValidationUtils.isRun(0));
    }
}