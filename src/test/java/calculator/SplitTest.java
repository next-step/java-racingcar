package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SplitTest {

    @DisplayName("split 학습테스트 - 숫자 2개 이상")
    @ParameterizedTest
    @ValueSource(strings = {"1,2", "1:2", "1,2:3"})
    void split(String input) {
        assertThat(input.split(",|:")).contains("1", "2");
    }

    @DisplayName("split 학습테스트 - 숫자 1개")
    @ParameterizedTest
    @ValueSource(strings = {"1"})
    void split2(String input) {
        assertThat(input.split(",|:")).containsExactly("1");
    }
}
