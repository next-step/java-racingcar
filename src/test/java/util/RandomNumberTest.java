package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberTest {

    @Test
    @DisplayName("범위에 맞는 random 값을 구한다.")
    void test_random_number_size() {
        assertThat(RandomNumber.generate(10)).isBetween(0, 9);
    }
}