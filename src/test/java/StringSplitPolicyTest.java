import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringSplitPolicyTest {

    @DisplayName("문자는 세미콜론(;)을 기준으로 나뉜다.")
    @Test
    void StringSplitPolicy_semicolon() {
        String input = "1;-2;3";
        assertThat(StringSplitPolicy.splitByPolicy(input))
            .containsExactly("1", "-2", "3");
    }

    @DisplayName("문자열은 컴마(,)를 기준으로 나뉜다.")
    @Test
    void StringSplitPolicy_comma() {
        String input = "1,-2,3";
        assertThat(StringSplitPolicy.splitByPolicy(input))
            .containsExactly("1", "-2", "3");
    }

    @DisplayName("콜론과 세미콜론은 함께 구분자로 쓰일 수 있다.")
    @Test
    void StringSplitPolicy_comma_and_semicolon() {
        String input = "1,-2;3";
        assertThat(StringSplitPolicy.splitByPolicy(input))
            .containsExactly("1", "-2", "3");
    }

    @DisplayName("문자열 맨 앞의 \"//\"와 \"\\n\" 사이에 커스텀 구분자를 지정할 수 있다.")
    @Test
    void StringSplitPolicy_custom() {
        String input = "//~\n1~-2~3";
        String[] splitStrings = StringSplitPolicy.splitByPolicy(input);
        assertThat(splitStrings).containsExactly("1", "-2", "3");
    }
}