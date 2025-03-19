package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarNameTest {

    @Test
    @DisplayName("공백으로 이름 불가")
    void constructor() {
        assertThrows(IllegalArgumentException.class, () -> new CarName(""));
        assertThrows(IllegalArgumentException.class, () -> new CarName(" "));
    }

    @Test
    @DisplayName("5자 초과 이름 불가")
    void constructor_2() {
        assertThrows(IllegalArgumentException.class, () -> new CarName("123456"));
    }

}
