package stage4.domain;

import org.junit.jupiter.api.Test;
import stage4.exception.TooLongCarNameException;

import static org.junit.jupiter.api.Assertions.*;

class CarNameTest {
    @Test
    void failTestIfCarNameMoreThenFive() {
        assertThrows(TooLongCarNameException.class, () -> new CarName("123456"));
    }

    @Test
    void failTestIfCarNameIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> new CarName(""));
    }

    @Test
    void failTestIfCarNameIsBlank() {
        assertThrows(IllegalArgumentException.class, () -> new CarName(" "));
    }
}