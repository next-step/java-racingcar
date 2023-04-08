package racing.carRacing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CountTest {

    @Test
    @DisplayName("정상적인 숫자 입력 시 Count 변환")
    void rightNumberTest() {
        String test = "123";

        Count result = Count.createCount(test);

        assertThat(result).usingRecursiveComparison()
                .isEqualTo(new Count(123L));
    }

    @Test
    @DisplayName("숫자가 아닐 때 에러 반환")
    void wrongNumberTest() {
        String test = "test";

        assertThatThrownBy(
                () -> Count.createCount(test))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-100"})
    @DisplayName("0보다 작은 숫자일 때 에러 반환")
    void negativeOrZeroNumberTest(String input) {
        assertThatThrownBy(
                () -> Count.createCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}