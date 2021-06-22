package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class CarStrategyTest {
    @DisplayName("난수는 0~9사이의 정수이다.")
    @Test
    void createRandomNumberTest() {
        Random random = new Random();
        assertThat(random.nextInt(10)).isBetween(0, 9);
    }
}
