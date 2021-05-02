package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {

    @Test
    @DisplayName("0-9까지 숫자 생성")
    void generate_random_number_0_to_9() {
        int number = RandomNumber.generateNumber();
        assertThat(number)
                .isBetween(0, 9);
    }
}
