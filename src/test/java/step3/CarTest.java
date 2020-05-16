package step3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("호출시 값을 +1 한다")
    void move() {
        int given = 1;
        given++;
        assertThat(given).isEqualTo(2);
    }
}