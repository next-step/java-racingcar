package Calculcator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitterTest {

    @DisplayName("split 메소드는 문자열 수식을 분리하여 String List 형태로 반환한다.")
    @Test
    void split() {
        String expression = "2 + 3 * 4 / 2";
        List<String> splits = Splitter.split(expression);

        assertThat(splits).containsExactly("2", "+", "3", "*", "4", "/", "2");
    }
}
