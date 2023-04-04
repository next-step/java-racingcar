package step1.unit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @ParameterizedTest(name = "Split Test - 개별 요소 확인 (input: ''{0}'')")
    @ValueSource(strings = {"1", "1,2", "3,4", "5,6,7"})
    void input_array_check_element(String input) {
        String[] split = input.split(",");

        for (String s : split) {
            assertThat(split).contains(s);
        }
    }

    @ParameterizedTest(name = "Split Test - 배열 순서 확인 (input: ''{0}'')")
    @ValueSource(strings = {"1", "1,2", "3,4", "5,6,7"})
    void input_array_check_list(String input) {
        String[] split = input.split(",");
        List<String> list = List.of(split);
        assertThat(list).containsExactly(split);
    }
}
