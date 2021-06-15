package carracing;

import carracing.model.RandomNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {
    @DisplayName("난수는 0~9사이의 정수이다.")
    @Test
    void createRandomNumberTest() {
        assertThat(RandomNumber.createRandomNumber()).isBetween(0, 9);
    }
}
