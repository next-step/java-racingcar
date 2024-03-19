package game.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DistanceTest {

    Distance distance;

    @BeforeEach
    void setUp() {
        distance = new Distance(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"4:2", "7:2", "9:2", "0:1", "3:1"}, delimiter = ':')
    @DisplayName("0~9 사이의 숫자가 넘어온다")
    void normal_number(int number, int result) {
        distance.move(number);
        assertThat(distance).isEqualTo(new Distance(result));
    }

    @Test
    @DisplayName("9보다 큰 숫자가 넘어온다")
    void larger_than_max_number() {
        final int MAX_NUMBER = 9;
        assertThatThrownBy(() -> {
            distance.move(MAX_NUMBER + 1);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("음수가 넘어온다")
    void negative() {
        assertThatThrownBy(() -> {
            distance.move(-1);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("toString 테스트")
    void to_string_test() {
        String test = new Distance(5).toString();
        assertThat(test).isEqualTo("-----");
    }
}