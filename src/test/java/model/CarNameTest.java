package model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CarNameTest {
    @Test
    public void CarNameLengthNotValid() {
        assertThatThrownBy(() -> new CarName("123456")).isInstanceOf(RuntimeException.class);
    }
}
