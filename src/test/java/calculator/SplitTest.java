package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SplitTest {

    @DisplayName(", 또는 : 를 구분자로 가지는 경우 구분자를 기준으로 분리")
    @ParameterizedTest
    @ValueSource(strings = {"1,2", "1:2", "1,2:3"})
    void split(String input) {
        assertThat(input.split(",|:")).contains("1", "2");
    }
}
