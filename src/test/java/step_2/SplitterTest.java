package step_2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SplitterTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1,2:3", "//;\n1;2;3"})
    @DisplayName("주어진 인자를 쉼표 및 콜론, 커스텀 구분자를 기준으로 잘라내는지 테스트합니다.")
    void 구분자_기준_문자열_자르기(String value) {
        assertThat(Splitter.split().apply(value)).isEqualTo(List.of("1", "2", "3"));
    }
}